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
import com.nimap.JavaMiniProject.entity.Category;
import com.nimap.JavaMiniProject.service.ServiceCategory;

@RestController
@RequestMapping("/api")
public class ControllerCategory {

	@Autowired
	ServiceCategory service;

	//POST Create A New Category
	@PostMapping("/categories")
	public String addCategories(@RequestBody Category c) {
		String msg=service.addCategory(c);
		return msg;
	}

	//UPDATE Category By id
	@PutMapping("/categories/{category_id}")
	public String updateCategories(@PathVariable int category_id, @RequestBody Category c) {
		String msg=service.updateCategory(c,category_id);
		return msg;
	}

	//DELETE Category By id
	@DeleteMapping("/categories/{category_id}")
	public String deleteCategories(@PathVariable int category_id) {
		String msg= service.deleteCategory(category_id);
		return msg;
	}

	//GET Category By id
	@GetMapping("/categories/{category_id}")
	public Category getperticularData(@PathVariable int category_id) {
		Category c= service.getCategoryById(category_id);
		return c;
	}
	
	//GET All Categories 
	@GetMapping("/categories")
	public List<Category> getCategory() {
		List<Category> list= service.getAllCategory();
		return list;
	}
	
}



