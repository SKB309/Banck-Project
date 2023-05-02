package com.springBoot.BankAccount.BankAccount.Service;

import com.springBoot.BankAccount.BankAccount.Model.Account;
import com.springBoot.BankAccount.BankAccount.Model.Transaction;
import com.springBoot.BankAccount.BankAccount.Reposetry.AccountRepository;
import com.springBoot.BankAccount.BankAccount.Reposetry.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class TransactionService {


    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(Transaction transaction) {
        transactionRepository.delete(transaction);
    }


    private final AccountRepository accountRepository;
    private final EmailService emailService;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, EmailService emailService) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.emailService = emailService;

    }

    @Transactional
    public void makeTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        Account account = accountRepository.findById(Long.valueOf(transaction.getId())).orElseThrow();
        double balance = account.getBalance();
        if (balance < 100) { // Send email alert if balance is less than $100
            String subject = "Account Balance Alert";
            String message = "Your account balance has fallen below $100. Current balance: $" + balance;
            emailService.sendEmail(account.getCustomer().getEmail(), subject, message);
        }
        String subject = "Transaction Alert";
        String message = "A new transaction has been made on your account. Amount: $" + transaction.getAmount();
        emailService.sendEmail(account.getCustomer().getEmail(), subject, message);
    }
}
