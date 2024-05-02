package com.nimap.JavaMiniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nimap.JavaMiniProject.entity.Product;
import com.nimap.JavaMiniProject.service.ServiceProduct;

@RestController
@RequestMapping("/api")
public class ControllerProduct {
	
	@Autowired
	ServiceProduct service;
	
	@PostMapping("/products")
	public String addProduct(@RequestBody Product p) {
		String msg = service.addProduct(p);
		return msg;
	}
	
	@PutMapping("/products/{product_id}")
	public String updateProducts(@PathVariable int product_id, @RequestBody Product p) {
		String msg=service.updateProduct(p,product_id);
		return msg;
	}
	
	@DeleteMapping("/products/{product_id}")
	public String deleteCategories(@PathVariable int product_id) {
		String msg= service.deleteProduct(product_id);
		return msg;
	}
	
	@GetMapping("/products/{product_id}")
	public Product getperticularData(@PathVariable int product_id) {
		Product p= service.getProductById(product_id);
		return p;
	}
	
	@GetMapping("/products")
	public List<Product> getProduct() {
		List<Product> list= service.getAllProduct();
		return list;
	}
	
}
