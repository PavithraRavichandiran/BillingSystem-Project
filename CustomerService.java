  package com.edubridge.service;
  
  import java.util.List;
import java.util.Optional;
  
  import com.edubridge.entity.Customer;
import com.edubridge.entity.Product;
  
  public interface CustomerService { 
	  public Customer saveCustomer(Customer customer); 
	  public Customer getCustomerByContactNumber(String customerMobileNo);
	  public List<Customer> getAllCustomerByName(String customerName);
	  public Customer getCustomerByName(String customerName);
	  public List<Customer> getAllCustomers();
  public void removeCustomer(String customerId );
  public  Customer updateCustomer(String customerName,Customer customer) throws Exception;
  }
 