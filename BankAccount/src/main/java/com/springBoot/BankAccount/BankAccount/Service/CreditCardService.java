package com.springBoot.BankAccount.BankAccount.Service;

import com.springBoot.BankAccount.BankAccount.Model.CreditCard;
import com.springBoot.BankAccount.BankAccount.Reposetry.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class CreditCardService {



    @Autowired
    CreditCardRepository creditCardRepository;


//    public CreditCard getCreditCardById(Long id) {
//        return creditCardRepository.findById(id).orElse(null);
//    }
//
//    public List<CreditCard> getAllCreditCards() {
//        return creditCardRepository.findAll();
//    }
//
//    public void saveCreditCard(CreditCard creditCard) {
//        creditCardRepository.save(creditCard);
//    }
//
//    public void deleteCreditCard(CreditCard creditCard) {
//        creditCardRepository.delete(creditCard);
//    }

    public CreditCard createCardNumber(long accountNumber, LocalDate expiryDate, Integer customer_id) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(accountNumber);
        creditCard.setExpiryDate( expiryDate);
        creditCard.setId(customer_id);
        return creditCardRepository.save(creditCard);
    }






    public void saveCardNumber(long accountNumber, LocalDate expiryDate, Integer customer_id) {

        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(accountNumber);
        creditCard.setExpiryDate(expiryDate);
        creditCard.setId(customer_id);
        creditCardRepository.save(creditCard);


    }
}
