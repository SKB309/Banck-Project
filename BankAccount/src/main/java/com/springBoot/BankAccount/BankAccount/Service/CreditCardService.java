package com.springBoot.BankAccount.BankAccount.Service;

import com.springBoot.BankAccount.BankAccount.Model.CreditCard;
import com.springBoot.BankAccount.BankAccount.Model.Customer;
import com.springBoot.BankAccount.BankAccount.Reposetry.CreditCardRepository;
import com.springBoot.BankAccount.BankAccount.Reposetry.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class CreditCardService {



    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    private CustomerRepository customerRepository;


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

    public CreditCard createCardNumber(long accountNumber,String ActiveDate, String expiryDate, Integer customer_id) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(accountNumber);

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = sdf.format(now);
        creditCard.setActiveDate(formattedDate);
        creditCard.setExpiryDate(formattedDate);
        creditCard.setId(customer_id);
        return creditCardRepository.save(creditCard);
    }






    public void saveCardNumber(long accountNumber,String ActiveDate, String expiryDate, Integer customer_id) {

        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(accountNumber);

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//        SimpleDateFormat sdfo = new SimpleDateFormat("yy/MM");
        String formattedDateA = sdf.format(now);
//        String formattedDateE = sdfo.format(now);
        creditCard.setActiveDate(formattedDateA);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        LocalDate currentDate = LocalDate.now();

        // Add 5 years to the current date
        LocalDate expiryDateE = currentDate.plusYears(5);

        // Format the dates as "yyyy/mm/dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/YY");
        String currentDateString = formatter.format(currentDate);
        String expiryDateString = formatter.format(expiryDateE);

        // Print the results
//        System.out.println("Current date: " + currentDateString);
//        System.out.println("Expiry date: " + expiryDateString);

        creditCard.setExpiryDate(expiryDateString);
        Customer customer = customerRepository.findById(customer_id).get();
        creditCard.setCustomer(customer);
        creditCardRepository.save(creditCard);


    }
}
