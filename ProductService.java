package com.edubridge.service;

import java.util.List;

import com.edubridge.entity.Product;

public interface ProductService  {
	
    public Product saveProduct(Product product);
    public List<Product> getAllProducts();
    public  Product getProductById(String product_id);
    public void removeProduct(String product_id);
   public  Product updateProduct(String product_id,Product product);
}
