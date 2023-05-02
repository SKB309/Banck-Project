package com.springBoot.BankAccount.BankAccount.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "account_number")
    private Integer accountNumber;
    public static void setAccountNumber(Integer accountNumber) {
        accountNumber = accountNumber;
    }

    @Column(name = "balance")
    private float balance;
    public static void setBalance(Integer balance) {
        balance = balance;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaction> transactions;




}
