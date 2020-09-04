package com.chozoi.test.app.controller;

import com.chozoi.test.app.dtos.TransactionDTO;
import com.chozoi.test.domain.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/transaction")
public class Controllers {

    @Autowired private TransactionService transactionService;

    @PostMapping("send")
    ResponseEntity<?> transaction(@RequestBody TransactionDTO transactionDTO){
        return transactionService.moneyTransaction(transactionDTO);
    }

    @GetMapping("get/{id}")
    ResponseEntity<?> findByCustomerAndDate(@PathVariable("id") String id,
                                            @RequestParam("start") Date startDate,
                                            @RequestParam("end") Date endDate){
        return transactionService.findByCustomerAndDate(Integer.parseInt(id), startDate, endDate);
    }

}
