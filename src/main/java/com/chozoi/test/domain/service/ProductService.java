package com.chozoi.test.domain.service;

import com.chozoi.test.app.dtos.ProductDTO;
import com.chozoi.test.domain.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService{

    public ResponseEntity<?> addProduct(ProductDTO productDTO){
        Product saved = Product.builder()
                        .name(productDTO.getName())
                        .moneyOfProduct(productDTO.getMoneyOfProduct())
                        .build();

        saved = productRepository.save(saved);
        return ResponseEntity.ok("Success");
    }

    public ResponseEntity<?> findProductById(long id){
        Product product = productRepository.findById(id);
        return ResponseEntity.ok(modelMapper.productToResponse(product));
    }
}
