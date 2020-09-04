package com.chozoi.test.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerDTO {

    @JsonProperty("password")
    private String password;

    @JsonProperty("card_number_partner")
    private String cardNumberPartner;

    @JsonProperty("money_partner")
    private long moneyOfPartner;

    @JsonProperty("transactions")
    private List<TransactionDTO> transactions;
}
