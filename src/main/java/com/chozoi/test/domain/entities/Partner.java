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
@Table(name = "partner")
public class Partner{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "card_number_partner", nullable = false)
    private String cardNumberPartner;

    @Column(name = "money")
    private long moneyOfPartner;

    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY)
    private List<Transaction> transactions;

}
