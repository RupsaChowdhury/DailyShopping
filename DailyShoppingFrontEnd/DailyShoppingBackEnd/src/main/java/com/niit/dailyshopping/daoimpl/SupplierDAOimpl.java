package com.niit.dailyshopping.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dailyshopping.dao.SupplierDAO;
import com.niit.dailyshopping.domain.Supplier;




@Transactional
@Repository("supplierDAO") 
public class SupplierDAOimpl implements SupplierDAO {



	@Autowired 
	private SessionFactory sessionFactory;

	@Autowired
	private Supplier supplier;

	//
	public boolean save(Supplier supplier) {
		
		try {
			
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Supplier get(String emailID) {
		
		return sessionFactory.getCurrentSession().get(Supplier.class, emailID);

	}

	public boolean delete(String emailID) {
		try {
			supplier = get(emailID);
			if (supplier == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(supplier);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<Supplier> list() {
	return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	

}










