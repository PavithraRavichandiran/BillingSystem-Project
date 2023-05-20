
  package com.edubridge.service;
  
  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Customer;
import com.edubridge.repository.CustomerRepository;
  @Service
  public class CustomerServiceImpl implements CustomerService{
  
  @Autowired CustomerRepository customerRepository;
  
  @Override
  public Customer saveCustomer(Customer customer) { 
	  return  customerRepository.save(customer);
  }

@Override
public List<Customer> getAllCustomers() {
	// TODO Auto-generated method stub
	return customerRepository.findAll();
}

@Override
public List<Customer> getAllCustomerByName(String customerName) {
	// TODO Auto-generated method stub
	return customerRepository.findAllByCustomerName(customerName);
}
  
  

  @Override public Customer getCustomerByContactNumber(String customerMobileNo)
  {
	  System.out.println("Inside service customer by contact number");
  
  return customerRepository.findByCustomerMobileNo(customerMobileNo);
  }

@Override
public void removeCustomer(String customerId) {
	// TODO Auto-generated method stub
	 customerRepository.deleteById(customerId);
}

@Override
public Customer updateCustomer(String customerName, Customer customer) {
	Customer customer1 =getCustomerByName(customerName);
	
	customer1.setCustomerName(customer.getCustomerName());
	customer1.setCustomerMobileNo(customer.getCustomerMobileNo());
	return customerRepository.save(customer1);
}

@Override
public Customer getCustomerByName(String customerName) {
	return customerRepository.findByCustomerName(customerName);
	
}



  }
 
     