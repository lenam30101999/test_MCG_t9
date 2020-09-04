package com.chozoi.test.app.dtos;

import com.chozoi.test.domain.entities.Transaction;
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
public class CustomerDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;

    @JsonProperty("card_number_customer")
    private String cardNumberCustomer;

    @JsonProperty("money")
    private long moneyOfCustomer;

    @JsonProperty("transactions")
    private List<Transaction> transactions;
}
