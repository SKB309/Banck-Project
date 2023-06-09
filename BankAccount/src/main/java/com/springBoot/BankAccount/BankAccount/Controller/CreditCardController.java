package com.springBoot.BankAccount.BankAccount.Controller;

import com.springBoot.BankAccount.BankAccount.Service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RequestMapping (value = "CreditCard")
@RestController
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;


    @RequestMapping(value = "CreditCardData" ,method = RequestMethod.POST)
    public void createCreditCard(@RequestParam long accountNumber , String ActiveDate, String expiryDate , Integer customer_id) throws ParseException {
        creditCardService.saveCardNumber(accountNumber , ActiveDate, expiryDate, customer_id);
    }
}
