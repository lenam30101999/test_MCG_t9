package com.chozoi.test.domain.repositories;

import com.chozoi.test.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Customer save(Customer customer);

    Customer findByIdAndPassword(int id, String password);

    Customer findByCardNumberCustomer(String cardNumber);
}
