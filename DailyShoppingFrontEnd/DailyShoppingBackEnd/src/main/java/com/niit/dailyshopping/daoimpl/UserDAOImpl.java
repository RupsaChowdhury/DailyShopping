package com.niit.dailyshopping.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dailyshopping.dao.UserDAO;
import com.niit.dailyshopping.domain.User;
import com.niit.dailyshopping.daoimpl.UserDAOImpl;



@Transactional
@Repository("userDAO") 
public class UserDAOImpl implements UserDAO {
	private static final Logger log= LoggerFactory.getLogger(UserDAOImpl.class);



	@Autowired 
	private SessionFactory sessionFactory;

	@Autowired
	private User user;

	//
	public boolean save(User user) {
		log.debug("starting of the save method");
		
				try {
					user.setRole('C');
					user.setRegisteredDate(new Date(System.currentTimeMillis()) + "");
					sessionFactory.getCurrentSession().save(user);
					log.debug("ending of the save method");
					return true;
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}

			}

			public boolean update(User user) {
				log.debug("starting of the update method");
				try {
					sessionFactory.getCurrentSession().update(user);
					log.debug("ending of the update method");
					return true;
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("Error occured in update method"+e.getMessage());
					return false;
				}

			}
			public User get(String emailID) {
				log.debug("starting of the get method");
				
				return sessionFactory.getCurrentSession().get(User.class, emailID);

			}

			public boolean delete(String emailID) {
				log.debug("starting of the delete method");
				try {
					user = get(emailID);
					if (user == null) {
						return false;
					}

					sessionFactory.getCurrentSession().delete(user);
					log.debug("ending of the delete method");

					return true;
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}

			}

			public List<User> list() {
				log.debug("starting of the list method");
			return	sessionFactory.getCurrentSession().createQuery("from User").list();
			}
			
			public User validate(String emailID, String password) {
				
				log.debug("starting of the validate method");
				log.info("users"+emailID+"trying to login");
			user=(User)  sessionFactory.getCurrentSession().createCriteria(User.class)
			.add(Restrictions.eq("emailID", emailID))
		    .add(Restrictions.eq("pwd",password)).uniqueResult();
			
			return user;
			}

			
			}

		
		

	

