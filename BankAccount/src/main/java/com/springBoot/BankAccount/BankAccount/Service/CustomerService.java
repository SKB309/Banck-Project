package com.springBoot.BankAccount.BankAccount.Service;

import com.springBoot.BankAccount.BankAccount.Model.Customer;
import com.springBoot.BankAccount.BankAccount.Reposetry.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

     @Autowired
     CustomerRepository customerRepository;



    public List<Customer> getAllCustomer() {

        return customerRepository.getAllCustomer();


    }

    public Customer getCustomerById(Integer id) {

        return customerRepository.getCustomerById(id);

    }


    public void saveCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {

        customerRepository.delete(customer);
    }
    public Customer createCustomer(String customerName, String email, Integer phoneNumber) {
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        return customerRepository.save(customer);
    }

    public void saveCustomer(String customerName, String email, String phoneNumber) {

        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setEmail(email);
        customer.setPhoneNumber(Integer.parseInt(phoneNumber));
        customerRepository.save(customer);
    }
}
