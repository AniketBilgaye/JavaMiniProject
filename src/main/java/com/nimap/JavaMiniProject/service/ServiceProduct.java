package com.nimap.JavaMiniProject.service;

import java.util.List;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nimap.JavaMiniProject.dao.DaoProduct;
import com.nimap.JavaMiniProject.entity.Product;

@Service
public class ServiceProduct {

	@Autowired
	DaoProduct dao;

	public String addProduct(Product p) {
		String msg=dao.addProduct(p);
		if(Objects.isNull(msg)) {
			msg="Product  is not inserted !!!";
		}return msg;
	}

	public String updateProduct(Product p, int product_id) {
		String msg=dao.updateProduct(p,product_id);
		if(Objects.isNull(msg)) {
			msg="The Given Product Is Not Updated !!!";
		}return msg;
	}

	public String deleteProduct(int product_id) {
		String msg= dao.deleteProduct(product_id);
		if(Objects.isNull(msg)) {
			msg="The Given product Is Not Deleted";
		}return msg;

	}

	public Product getProductById(int product_id) {
		Product p=dao.getProductById(product_id);
		return p;
	}

	public List<Product> getAllProduct() {
		List<Product> list = dao.getAllProduct();
		return list;
	}

}
