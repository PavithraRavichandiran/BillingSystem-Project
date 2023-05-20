
package com.edubridge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.entity.Customer;
import com.edubridge.entity.Product;
import com.edubridge.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController

public class CustomerController {

	@Autowired
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
		System.out.println("Customer Controller");
	}

	@PostMapping("/AddCustomers")
	public ResponseEntity<Customer> saveCustomer(@Validated @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);

	}

	@GetMapping("/FetchCustomers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/Contact/{customerMobileNo}")
	public ResponseEntity<Customer> getCustomerByContactNumber(
			@PathVariable("customerMobileNo") String customerMobileNo) {
		System.out.println("Inside customer by contact number");
		return new ResponseEntity<Customer>(customerService.getCustomerByContactNumber(customerMobileNo),
				HttpStatus.OK);
	}

	@GetMapping("/Name/{customerName}")
	public Customer getCustomerByName(@PathVariable("customerName") String customerName) {
		return (customerService.getCustomerByName(customerName));
	}

	@DeleteMapping("/Remove/{customerId}")
	
	public ResponseEntity<Map<String, String>> removeCustomer(@PathVariable("customerId") String customerId){
	    customerService.removeCustomer(customerId);
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "Customer deleted successfully");
	    return ResponseEntity.ok().body(response);
	}


	@PutMapping("/update/{customerName}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerName") String customerName,
			@RequestBody Customer customer) throws Exception {
		customerService.updateCustomer(customerName, customer);
		return new ResponseEntity<Customer>(HttpStatus.OK);

	}

}
