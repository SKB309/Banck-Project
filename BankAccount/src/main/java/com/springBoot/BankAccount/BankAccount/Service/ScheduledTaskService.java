package com.springBoot.BankAccount.BankAccount.Service;

import com.springBoot.BankAccount.BankAccount.Model.Account;
import com.springBoot.BankAccount.BankAccount.Reposetry.AccountRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledTaskService {
    private final AccountRepository accountRepository;
    private final EmailService emailService;

    public ScheduledTaskService(AccountRepository accountRepository, EmailService emailService) {
        this.accountRepository = accountRepository;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 0 0 * * *") // Run at midnight every day
    public void checkBalances() {
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            double balance = account.getBalance();
            if (balance < 100) { // Send email alert if balance is less than $100
                String subject = "Account Balance Alert";
                String message = "Your account balance has fallen below $100. Current balance: $" + balance;
                emailService.sendEmail(account.getCustomer().getEmail(), subject, message);
            }
        }
    }
}
