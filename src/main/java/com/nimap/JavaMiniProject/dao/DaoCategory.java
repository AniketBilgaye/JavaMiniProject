package com.nimap.JavaMiniProject.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nimap.JavaMiniProject.entity.Category;

@Repository
public class DaoCategory {

	@Autowired
	SessionFactory factory;

	public String addCategory(Category c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg="Category inserted";
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

	public String updateCategory(Category c,int category_id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Category category=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			category=session.get(Category.class, category_id);
			category.setCategory_name(c.getCategory_name());
			session.merge(category);
			tx.commit();
			msg="The Given Category Is Updated Succefully";

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

	public String deleteCategory(int category_id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Category cc= session.get(Category.class,category_id );
			session.remove(cc);
			tx.commit();
			msg="The Given Category is Deleted Succefully";

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

	public Category geCategoryById(int category_id) {
		Session session=null;
		Transaction tx=null;
		Category c=null;

		try {
			session= factory.openSession();
			tx=session.beginTransaction();   		 
			String hqlquery="from Category where category_id=:myid";    		 
			Query<Category>query =session.createQuery(hqlquery,Category.class);   		 
			query.setParameter("myid", category_id);
			c= query.uniqueResult();		 
			tx.commit();	
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();	
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}return c;
	}

	public List<Category> getAllCategory() {
		Session session=null;
		Transaction tx=null;
		List<Category> list=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Category ";
			Query<Category>query = session.createQuery(hqlQuery,Category.class);
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
