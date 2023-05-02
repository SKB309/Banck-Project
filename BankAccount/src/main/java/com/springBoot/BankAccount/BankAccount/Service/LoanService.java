package com.springBoot.BankAccount.BankAccount.Service;

import com.springBoot.BankAccount.BankAccount.Model.Customer;
import com.springBoot.BankAccount.BankAccount.Model.Loan;
import com.springBoot.BankAccount.BankAccount.Reposetry.LoanRepository;
import com.springBoot.BankAccount.BankAccount.Slack.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoanService {


    @Autowired
     LoanRepository loanRepository;
    SlackService slackService;
    Customer customer;
    Loan loan;




    public Loan getLoanById(Long id) {

        return loanRepository.findById(id).orElse(null);
    }

    public List<Loan> getAllLoans() {

        return loanRepository.findAll();
    }

    public void saveLoan(Loan loan) {

        loanRepository.save(loan);
    }

    public void deleteLoan(Loan loan) {

        loanRepository.delete(loan);
    }


    public LoanService(LoanRepository loanRepository) {

        this.loanRepository = loanRepository;
    }




//    public LoanService(LoanRepository loanRepository, SlackService slackService) {
//        this.loanRepository = loanRepository;
//        this.slackService = slackService;
//    }
//
//    public void approveLoanApplication(Loan loan) {
//        loan.setStatus(Boolean.parseBoolean("approved"));
//        loanRepository.save(loan);
//        String message = "Loan application approved. Customer: " + loan.getCustomer().getCustomerName(CustomerName) + ", Amount: $" + loan.getLoanAmount();
//        slackService.sendMessage(message);
//    }
//
//    public void rejectLoanApplication(Loan loan) {
//        loan.setStatus(Boolean.parseBoolean("rejected"));
//        loanRepository.save(loan);
//        String message = "Loan application rejected. Customer: " + loan.getCustomer().getCustomerName(CustomerName) + ", Amount: $" + loan.getLoanAmount();
//        slackService.sendMessage(message);
//    }

}