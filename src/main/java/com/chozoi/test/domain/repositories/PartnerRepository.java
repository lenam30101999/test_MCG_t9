package com.chozoi.test.domain.repositories;

import com.chozoi.test.domain.entities.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    Partner save(Partner partner);

    Partner findByCardNumberPartner(String cardNumber);
}
