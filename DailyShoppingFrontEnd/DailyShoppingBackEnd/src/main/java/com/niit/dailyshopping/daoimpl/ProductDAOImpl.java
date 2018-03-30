package com.niit.dailyshopping.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dailyshopping.dao.ProductDAO;
import com.niit.dailyshopping.domain.Product;




@Transactional
@Repository("productDAO") 
public class ProductDAOImpl implements ProductDAO {

	

	@Autowired 
	private SessionFactory sessionFactory;

	@Autowired
	private Product product;

	//
	public boolean save(Product product) {
		
		try {
			
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Product get(String id) {
		
		return sessionFactory.getCurrentSession().get(Product.class, id);

	}

	public boolean delete(String id) {
		try {
			product = get(id);
			if (product == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(product);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<Product> list()
	{
	return	sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	

	
}










