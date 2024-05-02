package com.nimap.JavaMiniProject.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.JavaMiniProject.dao.DaoCategory;
import com.nimap.JavaMiniProject.entity.Category;

@Service
public class ServiceCategory {

	@Autowired
	DaoCategory dao;

	public String addCategory(Category c) {
		String msg=dao.addCategory(c);
		if(Objects.isNull(msg)) {
			msg="Category is not inserted !!!";
		}
		return msg;
	}

	public String updateCategory(Category c, int category_id) {
		String msg=dao.updateCategory(c,category_id);
		if(Objects.isNull(msg)) {
			msg="The Given Category Is Not Updated !!!";
		}
		return msg;
	}

	public String deleteCategory(int category_id) {
		String msg= dao.deleteCategory(category_id);
		if(Objects.isNull(msg)) {
			msg="The Given Category Is Not Deleted";
		}
		return msg;
	}

	public Category getCategoryById(int category_id) {

		Category c=dao.geCategoryById(category_id);
		return c;
	}

	public List<Category> getAllCategory() {
		List<Category> list = dao.getAllCategory();
		return list;
	}


}
