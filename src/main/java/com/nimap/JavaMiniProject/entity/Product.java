package com.nimap.JavaMiniProject.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	private String company_name;
	private String product_name;
	private String status;
	private String validity; 
	private int price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="category_id")
	private Category category;
	
	public Product() {}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(long product_id, String company_name, String product_name, String status, String validity,
			int price, Category category) {
		super();
		this.product_id = product_id;
		this.company_name = company_name;
		this.product_name = product_name;
		this.status = status;
		this.validity = validity;
		this.price = price;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", company_name=" + company_name + ", product_name=" + product_name
				+ ", status=" + status + ", validity=" + validity + ", price=" + price + ", category=" + category + "]";
	}

	
}
