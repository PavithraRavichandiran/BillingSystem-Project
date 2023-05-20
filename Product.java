package com.edubridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Entity
@Table(name="Products")
@Component
public class Product {
	
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="product_sequence")
	@GenericGenerator( name="product_sequence",strategy="com.edubridge.specialfunctions.CustomIdGenerator",parameters= {
			@Parameter(name=com.edubridge.specialfunctions.CustomIdGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=com.edubridge.specialfunctions.CustomIdGenerator.VALUE_PREFIX_PARAMETER,value="PROD_"),
			@Parameter(name=com.edubridge.specialfunctions.CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value="%04d")
			
	})
	@Id
    public String product_id;

@Column(name="Name")
private String productName;

@Column(name="Price")
 public double productPrice;


@Column(name="Quantity")
public  int productQuantity;

@Column(name="Availability")
private String status;
}