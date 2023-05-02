package com.springBoot.BankAccount.BankAccount.Reposetry;

import com.springBoot.BankAccount.BankAccount.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
