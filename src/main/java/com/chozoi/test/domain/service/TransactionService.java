package com.chozoi.test.domain.service;

import com.chozoi.test.app.dtos.TransactionDTO;
import com.chozoi.test.domain.entities.Customer;
import com.chozoi.test.domain.entities.Partner;
import com.chozoi.test.domain.entities.Product;
import com.chozoi.test.domain.entities.Transaction;
import com.chozoi.test.domain.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class TransactionService extends BaseService{

    public ResponseEntity<?> moneyTransaction(TransactionDTO transactionDTO){
        Product product = productRepository.findById(transactionDTO.getProductId());
        long money = product.getMoneyOfProduct();

        Customer customer = customerRepository.findById(transactionDTO.getCustomerId()).orElse(null);
        if (Objects.isNull(customer)){
            throw new NotFoundException("Customer Not Found!");
        }

        Partner partner = partnerRepository.findById(transactionDTO.getPartnerId()).orElse(null);
        if (Objects.isNull(partner)){
            throw new NotFoundException("Partner Not Found!");
        }

        Transaction saved = Transaction.builder()
                            .name(transactionDTO.getName())
                            .moneyOfDeal(money)
                            .fee(getFee(money))
                            .customer(customer)
                            .partner(partner)
                            .product(product)
                            .build();

        if (checkAvailableMoney(customer.getMoneyOfCustomer(), money)){
            saved = transactionRepository.save(saved);
            deleteMoneyCustomer(customer.getCardNumberCustomer(), money);
            addMoneyPartner(partner, money);

            return ResponseEntity.ok("Success");
        }else {
            return ResponseEntity.ok("Not enough money!");
        }
    }

    public ResponseEntity<?> findByCustomerAndDate(int id, Date startDate, Date endDate){
        List<Transaction> transactions =
                transactionRepository.findAllByCustomerIdAndCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(id, startDate, endDate);
        List<TransactionDTO> dtos = convertListTransactionToDTOs(transactions);

        return ResponseEntity.ok(dtos);
    }

    private void deleteMoneyCustomer(String cardNumber, long price){
        Customer customer = customerRepository.findByCardNumberCustomer(cardNumber);

        long money = customer.getMoneyOfCustomer() - price - getFee(price);

        customer.setMoneyOfCustomer(money);
        customerRepository.saveAndFlush(customer);
    }

    private void addMoneyPartner(Partner partner, long price){
        long money = partner.getMoneyOfPartner() + price;
        partner.setMoneyOfPartner(money);

        partnerRepository.saveAndFlush(partner);
    }

    private boolean checkAvailableMoney(long moneyCustomer, long moneyTransaction){
        moneyTransaction = moneyTransaction + getFee(moneyTransaction);
        if (moneyCustomer >= moneyTransaction){
            return true;
        }else return false;
    }

    private long getFee(long money){
        if (money <= 100000){
            return 10000;
        }else if (money <= 500000){
            return (long) (0.02 * money);
        }else if (money <= 1000000){
            return (long) (0.015 * money);
        }else if (money <= 5000000){
            return (long) (0.01 * money);
        }else {
            return (long) (0.005 * money);
        }
    }

}
