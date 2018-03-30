package com.niit.DailyShoppingBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dailyshopping.dao.ProductDAO;
import com.niit.dailyshopping.domain.Product;



public class ProductDAOTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@Autowired
	private static Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
	
		context.scan("com.niit"); 
	
		context.refresh();
		
				productDAO = (ProductDAO)context.getBean("productDAO");
				product = (Product)context.getBean("product");
			}
			@Test
			public void saveProductTestCase()
			{
				product=new Product();
				product.setId("Lenovo-001");
				product.setName("Lenovo-product");
				product.setDescription("This is Lenovo Product");
				
			  boolean status = 	productDAO.save(product);
			  assertEquals("save product test case", true, status);
			}
			
			
			@Test
			public void updateProductTestCase()
			{
				product.setId("Lenovo");
				product.setName("Lenovo---prodect");
				product.setDescription("This is a mobile Product");
				boolean status = productDAO.update(product);
				assertEquals("update test case", true,status );
			}
			
			@Test
			public void getProductSuccessTestCase()
			{
				product= productDAO.get("Lenovo");
				
				assertNotNull("get product test case", product);
				}
				
				@Test
				public void getProductFailureTestCase()
				{
					
				product= productDAO.get("jaya@gmail.com");
				
				assertNull("get product test case", product);
				}
				
				@Test
				public void deleteProductSuccessTestCase()
				{
				boolean status =	productDAO.delete("Lenovo");
				assertEquals("delete product succss test case" , true, status);
				
				}
				@Test
				public void deleteProductFailureTestCase()
				{
				boolean status =	productDAO.delete("Lenovo");
				assertEquals("delete product failure test case" , false, status);
				
				}
				
				
				@Test
				public void getAllProductsTestCase()
				{
				List<Product>	products = productDAO.list();
				assertEquals("get all usres " , 3, products.size() );
				
				}
			
			}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
