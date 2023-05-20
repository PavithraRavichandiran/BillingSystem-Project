
  
  package com.edubridge.entity;
  
  import javax.persistence.Column; import javax.persistence.Entity; import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id; import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
  @Data
  @Entity
  @Table(name="Customers")
  
  public class Customer  {
  @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_sequence")
	@GenericGenerator( name="customer_sequence",strategy="com.edubridge.specialfunctions.CustomIdGenerator",parameters= {
			@Parameter(name=com.edubridge.specialfunctions.CustomIdGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=com.edubridge.specialfunctions.CustomIdGenerator.VALUE_PREFIX_PARAMETER,value="CUST_"),
			@Parameter(name=com.edubridge.specialfunctions.CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value="%04d")
			
	})
  @Id
  private String customerId;
  
  @Column(name="Name") 
  private String customerName;
  
  @NotBlank(message = "mobileNumber is required")
  @Size(min = 10, max = 10,message="Enter valid 10 digits number")
  @Column(name="ContactNumber",unique=true)
  private String customerMobileNo;	
  
  }
 
