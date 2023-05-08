package com.springBoot.BankAccount.BankAccount.Controller;

import com.springBoot.BankAccount.BankAccount.Model.Account;
import com.springBoot.BankAccount.BankAccount.Reposetry.AccountRepository;
import com.springBoot.BankAccount.BankAccount.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RequestMapping (value = "Account")
@RestController
public class AccountController {


    @Autowired
     AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("id")
    public Account getAccountById(@PathVariable Integer id) {
        return accountService.getAccountById(Long.valueOf(id));
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping
    public void saveAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
    }


    @RequestMapping(value = "AccountData" ,method = RequestMethod.POST)
    public void createAccount(@RequestParam Integer accountNumber, float balance ,  Integer customer_id) throws ParseException {
        accountService.saveAccount(accountNumber, balance,  customer_id);
    }


}
