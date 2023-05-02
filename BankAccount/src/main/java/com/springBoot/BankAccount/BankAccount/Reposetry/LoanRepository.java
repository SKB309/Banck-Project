package com.springBoot.BankAccount.BankAccount.Reposetry;

import com.springBoot.BankAccount.BankAccount.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {



}
