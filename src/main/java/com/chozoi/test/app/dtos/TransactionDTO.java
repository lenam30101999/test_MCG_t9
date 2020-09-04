package com.chozoi.test.app.dtos;

import com.chozoi.test.domain.entities.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO extends BaseEntity {
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("total_money")
    private long totalMoney;

    @JsonProperty("deal_date")
    private Date dealDate;

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("customer_id")
    private int customerId;

    @JsonProperty("partner_id")
    private int partnerId;
}
