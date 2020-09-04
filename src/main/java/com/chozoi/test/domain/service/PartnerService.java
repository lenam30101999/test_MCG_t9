package com.chozoi.test.domain.service;

import com.chozoi.test.app.dtos.PartnerDTO;
import com.chozoi.test.domain.entities.Partner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class PartnerService extends BaseService{

    ResponseEntity<?> add(PartnerDTO partnerDTO){
        Partner saved = Partner.builder()
                .password(partnerDTO.getPassword())
                .cardNumberPartner(partnerDTO.getCardNumberPartner())
                .moneyOfPartner(partnerDTO.getMoneyOfPartner())
                .build();

        saved = partnerRepository.save(saved);
        return ResponseEntity.ok("Success!");
    }

}
