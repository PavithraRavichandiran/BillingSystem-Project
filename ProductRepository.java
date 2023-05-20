package com.edubridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edubridge.entity.Product;

public interface ProductRepository extends JpaRepository<Product ,String> {
	
}

