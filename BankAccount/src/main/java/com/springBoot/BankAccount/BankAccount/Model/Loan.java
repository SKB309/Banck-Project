package com.springBoot.BankAccount.BankAccount.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "loan_amount")
    private double loanAmount;

    @Column(name = "interest_rate")
    private double interestRate;
    @Column(name = "Balance")
    private float balance;


    @Column(name = "Status")
    private boolean status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;





}
