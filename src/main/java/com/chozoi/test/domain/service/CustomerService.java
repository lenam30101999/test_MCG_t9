package com.chozoi.test.domain.service;

import com.chozoi.test.app.dtos.CustomerDTO;
import com.chozoi.test.domain.entities.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class CustomerService extends BaseService{

    public ResponseEntity<?> add(CustomerDTO customerDTO){
        Customer saved = Customer.builder()
                        .password(customerDTO.getPassword())
                        .name(customerDTO.getName())
                        .cardNumberCustomer(customerDTO.getCardNumberCustomer())
                        .moneyOfCustomer(customerDTO.getMoneyOfCustomer())
                        .build();
        saved = customerRepository.save(saved);
        return ResponseEntity.ok("Success");
    }


}
