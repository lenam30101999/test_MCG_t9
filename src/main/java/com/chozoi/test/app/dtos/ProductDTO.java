package com.chozoi.test.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("money_of_product")
    private long moneyOfProduct;
}
