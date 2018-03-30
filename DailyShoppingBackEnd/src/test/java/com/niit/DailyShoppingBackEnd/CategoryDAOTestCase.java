package com.niit.DailyShoppingBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dailyshopping.dao.CategoryDAO;
import com.niit.dailyshopping.domain.Category;



public class CategoryDAOTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit"); 
		
		context.refresh();
	
				categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
				category = (Category)context.getBean("category");
			}
			@Test
			public void saveCategoryTestCase()
			{
				category=new Category();
				category.setId("Mob-001");
				category.setName("Mobile");
				category.setDescription("This is mobile category");
				
			  boolean status = 	categoryDAO.save(category);
			  assertEquals("save category test case", true, status);
			}
			
			
			@Test
			public void updateCategoryTestCase()
			{
				category.setId("Mob-001");
				category.setName("Mobile Category");
				category.setDescription("This is a new mobile category");
				boolean status = categoryDAO.update(category);
				assertEquals("update test case", true,status );
			}
			
			@Test
			public void getCategorySuccessTestCase()
			{
				category= categoryDAO.get("Mob-001");
				
				assertNotNull("get category test case", category);
				}
				
				@Test
				public void getCategoryFailureTestCase()
				{
					
				category= categoryDAO.get("Mob-001");
				
				assertNull("get category test case", category);
				}
				
				@Test
				public void deleteCategorySuccessTestCase()
				{
				boolean status =	categoryDAO.delete("jaskaran1@gmail.com");
				assertEquals("delete category succss test case" , true, status);
				
				}
				@Test
				public void deleteCategoryFailureTestCase()
				{
				boolean status =	categoryDAO.delete("Mob-001");
				assertEquals("delete category failure test case" , false, status);
				
				}
				
				
				@Test
				public void getAllCategorysTestCase()
				{
				List<Category>	categorys = categoryDAO.list();
				assertEquals("get all usres " , 3, categorys.size() );
				
				}
				
				}
			
	
	
	
	
	
	
	
	
	
	
	
	

	
	
