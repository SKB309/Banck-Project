package com.springBoot.BankAccount.BankAccount.Service;

import com.springBoot.BankAccount.BankAccount.Model.Account;
import com.springBoot.BankAccount.BankAccount.Reposetry.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {

    @Autowired
     AccountRepository accountRepository;

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }


    public Account createAccount(Integer accountNumber, float balance, Integer customer_id) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance((int) balance);
        account.setId(customer_id);
        return accountRepository.save(account);
    }

    public void saveAccount(Integer accountNumber, float balance , Integer customer_id) {

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance((int) balance);
        account.setId( customer_id);
        accountRepository.save(account);
    }

    public void saveAccount(Account account) {
    }
}
