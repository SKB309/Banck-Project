package com.springBoot.BankAccount.BankAccount.Controller;


import com.springBoot.BankAccount.BankAccount.Model.Customer;
import com.springBoot.BankAccount.BankAccount.Reposetry.CustomerRepository;
import com.springBoot.BankAccount.BankAccount.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RequestMapping (value = "Customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;


    @RequestMapping("getAllCustomer")
    public List<Customer> getAllCustomer() {
        List<Customer> schools = customerRepository.getAllCustomer();
        return schools;
    }

    @RequestMapping(value = "getCustomerById", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }


    @RequestMapping(value = "CustomerData" ,method = RequestMethod.POST)
    public void createCustomer(@RequestParam String customerName, String email, String phone) throws ParseException {
        customerService.saveCustomer(customerName, email, phone);
    }




}
