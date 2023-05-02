package com.springBoot.BankAccount.BankAccount.Service;

import com.springBoot.BankAccount.BankAccount.Model.CreditCard;
import com.springBoot.BankAccount.BankAccount.Reposetry.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreditCardService {



    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard getCreditCardById(Long id) {
        return creditCardRepository.findById(id).orElse(null);
    }

    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    public void saveCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }

    public void deleteCreditCard(CreditCard creditCard) {
        creditCardRepository.delete(creditCard);
    }

}
