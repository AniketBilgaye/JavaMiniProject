package com.nimap.JavaMiniProject.dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nimap.JavaMiniProject.entity.Product;

@Repository
public class DaoProduct {

	@Autowired
	SessionFactory factory;

	public String addProduct(Product p) {
		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(p);
			tx.commit();
			msg="Product inserted";
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}return msg;
	}

	public String updateProduct(Product p, int product_id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Product product=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			product=session.get(Product.class, product_id);
			product.setCompany_name(p.getCompany_name());
			product.setProduct_name(p.getProduct_name());
			product.setStatus(p.getStatus());
			product.setValidity(p.getValidity());
			product.setPrice(p.getPrice());
			product.setCategory(p.getCategory());
			session.merge(product);
			tx.commit();
			msg="The Given product Is Updated Succefully";

		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}return msg;
	}

	public String deleteProduct(int product_id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Product cc= session.get(Product.class,product_id );
			session.remove(cc);
			tx.commit();
			msg="The Given product is Deleted Succefully";

		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();	
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}return msg;

	}

	public Product getProductById(int product_id) {
		Session session=null;
		Transaction tx=null;
		Product p=null;

		try {
			session= factory.openSession();
			tx=session.beginTransaction();
			String hqlquery="from Product where product_id=:myid";
			Query<Product>query =session.createQuery(hqlquery,Product.class);
			query.setParameter("myid", product_id);
			p= query.uniqueResult();
			tx.commit();

		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();	
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}return p;

	}

	public List<Product> getAllProduct() {
		Session session=null;
		Transaction tx=null;
		List<Product> list=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Product ";
			Query<Product>query = session.createQuery(hqlQuery,Product.class) ;
			list= query.list();
			tx.commit();

		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();	 
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}return list;

	}
}
