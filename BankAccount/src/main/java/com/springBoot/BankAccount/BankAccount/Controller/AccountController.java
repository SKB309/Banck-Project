package com.springBoot.BankAccount.BankAccount.Controller;

import com.springBoot.BankAccount.BankAccount.Reposetry.AccountRepository;
import com.springBoot.BankAccount.BankAccount.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RequestMapping (value = "Account")
@RestController
public class AccountController {


    @Autowired
     AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

//    @GetMapping("id")
//    public Account getAccountById(@PathVariable Long id) {
//        return accountService.getAccountById(id);
//    }
//
//    @GetMapping
//    public List<Account> getAllAccounts() {
//        return accountService.getAllAccounts();
//    }
//
//    @PostMapping
//    public void saveAccount(@RequestBody Account account) {
//        accountService.saveAccount(account);
//    }


    @RequestMapping(value = "AccountData" ,method = RequestMethod.POST)
    public void createAccount(@RequestParam Integer accountNumber, float balance) throws ParseException {
        accountService.saveAccount(accountNumber, balance);
    }


}
