package com.chozoi.test.domain.repositories;

import com.chozoi.test.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    Product findById(long id);
}
