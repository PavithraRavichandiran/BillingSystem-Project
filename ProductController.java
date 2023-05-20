package com.edubridge.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.entity.Product;

import com.edubridge.service.ProductService;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	ProductController(ProductService productService){
		this.productService=productService;
	}
@PostMapping()
public ResponseEntity<Product> saveProduct(@RequestBody Product product){
	return new ResponseEntity<Product>( productService.saveProduct(product ),HttpStatus.CREATED );
	
	}

@GetMapping("/ListProducts")
public List<Product> getAllProducts(){
	return productService.getAllProducts();
}
@GetMapping("{product_id}")

public ResponseEntity<Product> getProductById(@PathVariable("product_id") String product_id){
	System.out.println("display product");
	return new ResponseEntity<Product>( productService.getProductById(product_id),HttpStatus.OK );
}
@DeleteMapping("/Delete/{product_id}")
public ResponseEntity<Map<String, String>> removeProduct(@PathVariable("product_id") String product_id){
    productService.removeProduct(product_id);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Product deleted successfully");
    return ResponseEntity.ok().body(response);
}


  @PutMapping("/update/{product_id}") 
  public ResponseEntity<Product> updateProduct(@PathVariable("product_id") String  product_id,@RequestBody Product
  product)
  {
	  productService.updateProduct(product_id, product); 
	 
  return new ResponseEntity<Product>(HttpStatus.OK); }
  

}
