package com.niit.dailyshopping.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dailyshopping.dao.CategoryDAO;
import com.niit.dailyshopping.domain.Category;



@Transactional
@Repository("categoryDAO") 
public class CategoryDAOImpl implements CategoryDAO {



	@Autowired 
	private SessionFactory sessionFactory;

	@Autowired
	private Category category;

	//
	public boolean save(Category category) {
		
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Category get(String id)
	{
	
		return sessionFactory.getCurrentSession().get(Category.class, id);

	}

	public boolean delete(String id) {
		try {
			category = get(id);
			if (category == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(category);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<Category> list() {
	return	sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	

}










