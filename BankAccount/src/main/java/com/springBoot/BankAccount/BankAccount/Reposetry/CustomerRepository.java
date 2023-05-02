package com.springBoot.BankAccount.BankAccount.Reposetry;

import com.springBoot.BankAccount.BankAccount.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query(value = "SELECT s from Customer s")
    List<Customer> getAllCustomer();


    @Query(value = "SELECT s from customer s where s.id = :id", nativeQuery = true)
    Customer getCustomerById(@Param("id") Integer id);








}
