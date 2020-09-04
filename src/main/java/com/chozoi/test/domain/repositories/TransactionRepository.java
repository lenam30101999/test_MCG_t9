package com.chozoi.test.domain.repositories;

import com.chozoi.test.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction save(Transaction deal);

    List<Transaction> findAllByCustomerIdAndCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(int id, Date startDate, Date endDate);

    List<Transaction> findAllByPartnerIdAndCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(int id, Date startDate, Date endDate);
}
