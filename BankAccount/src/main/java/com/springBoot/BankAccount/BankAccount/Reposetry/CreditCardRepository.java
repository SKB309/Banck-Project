package com.springBoot.BankAccount.BankAccount.Reposetry;

import com.springBoot.BankAccount.BankAccount.Model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
