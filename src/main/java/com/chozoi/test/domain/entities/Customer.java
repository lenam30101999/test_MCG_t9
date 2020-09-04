package com.chozoi.test.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "card_number_customer", nullable = false)
    private String cardNumberCustomer;

    @Column(name = "money")
    private long moneyOfCustomer;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Transaction> transactions;

}
