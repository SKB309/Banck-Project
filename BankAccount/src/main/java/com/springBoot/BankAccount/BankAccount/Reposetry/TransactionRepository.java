package com.springBoot.BankAccount.BankAccount.Reposetry;

import com.springBoot.BankAccount.BankAccount.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  TransactionRepository extends JpaRepository<Transaction, Long> {




}
