package com.chozoi.test;

import com.chozoi.test.app.dtos.CustomerDTO;
import com.chozoi.test.app.dtos.PartnerDTO;
import com.chozoi.test.app.dtos.ProductDTO;
import com.chozoi.test.app.dtos.TransactionDTO;
import com.chozoi.test.domain.entities.Customer;
import com.chozoi.test.domain.entities.Partner;
import com.chozoi.test.domain.entities.Product;
import com.chozoi.test.domain.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    @Mapping(target = "transactions", source = "transactions")
    PartnerDTO partnerToResponse(Partner partner);

    @Mapping(target = "transactions", source = "transactions")
    CustomerDTO customerToResponse(Customer customer);

    @Mappings({
            @Mapping(target = "customerId", source = "customer.id"),
            @Mapping(target = "partnerId", source = "partner.id"),
            @Mapping(target = "productId", source = "product.id"),
            @Mapping(target = "dealDate", source = "createdAt"),
            @Mapping(target = "totalMoney", ignore = true)
    })
    TransactionDTO transactionToResponse(Transaction transaction);

    ProductDTO productToResponse(Product product);
}
