package com.chozoi.test.domain.service;

import com.chozoi.test.ModelMapper;
import com.chozoi.test.app.dtos.CustomerDTO;
import com.chozoi.test.app.dtos.TransactionDTO;
import com.chozoi.test.domain.entities.Customer;
import com.chozoi.test.domain.entities.Transaction;
import com.chozoi.test.domain.repositories.CustomerRepository;
import com.chozoi.test.domain.repositories.PartnerRepository;
import com.chozoi.test.domain.repositories.ProductRepository;
import com.chozoi.test.domain.repositories.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BaseService {

    @Autowired protected TransactionRepository transactionRepository;

    @Autowired protected CustomerRepository customerRepository;

    @Autowired protected PartnerRepository partnerRepository;

    @Autowired protected ProductRepository productRepository;

    @Autowired ModelMapper modelMapper;

    private CustomerDTO login(int id, String password){
        Customer customer = customerRepository.findByIdAndPassword(id, password);
        return convertCustomerToDTO(customer);
    }

    protected CustomerDTO convertCustomerToDTO(Customer customer){
        return modelMapper.customerToResponse(customer);
    }

    protected TransactionDTO convertTransactionToDTO(Transaction transaction){
        return modelMapper.transactionToResponse(transaction);
    }

    protected List<TransactionDTO> convertListTransactionToDTOs(List<Transaction> models){
        return models.stream().map(this::convertTransactionToDTO).collect(Collectors.toList());
    }
}
