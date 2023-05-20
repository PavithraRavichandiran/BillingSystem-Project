package com.edubridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Product;
import com.edubridge.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
 private ProductRepository productRepository;
	@Override
	public Product saveProduct(Product product) {
	return	productRepository.save(product);
		
		}
	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}
	@Override
	public Product getProductById(String product_id) {
		return productRepository.findById(product_id).get();
	}
	@Override
	public void removeProduct(String product_id) {
		
		productRepository.deleteById(product_id);
	}
	
	
	
	  @Override 
	  public Product updateProduct(String product_id, Product product) {
	  Product product2=getProductById(product_id);
	  product2.setProductName(product.getProductName());
	  product2.setProductPrice(product.getProductPrice());
	  product2.setProductQuantity(product.getProductQuantity());
	  product2.setStatus(product.getStatus()); return
	  productRepository.save(product2);
	  
	  }
	 

}
