package com.niit.DailyShoppingBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dailyshopping.dao.UserDAO;
import com.niit.dailyshopping.domain.User;


public class UserDAOTestCase {

private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired
	private static User user;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
	
		context.scan("com.niit"); 
		
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User)context.getBean("user");
	}
	@Test
	public void saveUserTestCase()
	{
		user=new User();
		user.setEmailID("rupsa@gmail.com");
		user.setMobile("879546");
		user.setName("rupsa chowdhury");
		user.setPwd("rupsa123");
		
	  boolean status = 	userDAO.save(user);
	  assertEquals("save user test case", true, status);
	}
	
	
	@Test
	public void updateUserTestCase()
	{
		user.setEmailID("jaskaran1@gmail.com");
		user.setMobile("888888888");
		boolean status = userDAO.update(user);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getUserSuccessTestCase()
	{
	
		user= userDAO.get("jaskaran1@gmail.com");
		
		assertNotNull("get user test case", user);
		}
		
		@Test
		public void getUserFailureTestCase()
		{
			
		user= userDAO.get("jaya@gmail.com");
		
		assertNull("get user test case", user);
		}
		
		@Test
		public void deleteUserSuccessTestCase()
		{
		boolean status =	userDAO.delete("jaskaran1@gmail.com");
		assertEquals("delete user succss test case" , true, status);
		
		}
		@Test
		public void deleteUserFailureTestCase()
		{
		boolean status =	userDAO.delete("arpith@gmail.com");
		assertEquals("delete user failure test case" , false, status);
		}
		
		
		@Test
		public void getAllUsersTestCase()
		{
		List<User>	users = userDAO.list();
		assertEquals("get all usres " , 3, users.size() );
		
		}
		@Test
		public void validateCredentailsTestCase()
		{
		user = 	userDAO.validate("jaskaran@gmail.com", "jas@1234");
		assertNotNull("Validate test case",user );
		
		}
}
