package com.springBoot.BankAccount.BankAccount.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;


    @Column(name = "card_number")
    private long cardNumber;

    @Column(name = "Active_date")
    private String  ActiveDate;

    @Column(name = "expiry_date")
    private String  expiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
