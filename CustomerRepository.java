package com.edubridge.repository;
  
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edubridge.entity.Customer;


  public interface CustomerRepository extends JpaRepository<Customer,String> {
  public Customer findByCustomerName(String customerName);
  public List<Customer> findAllByCustomerName(String customerName);
  public Customer findByCustomerMobileNo(String customerMobileNo);
  
  }
 
