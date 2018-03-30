package com.niit.DailyShoppingBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dailyshopping.dao.SupplierDAO;
import com.niit.dailyshopping.domain.Supplier;



public class SupplierDAOTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static Supplier supplier;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
	
		context.scan("com.niit"); 
	
		context.refresh();
	
				supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
				supplier = (Supplier)context.getBean("supplier");
			}
			@Test
			public void saveSupplierTestCase()
			{
				supplier=new Supplier();
				supplier.setId("SUP-001");
				
				supplier.setName("BigC");
				supplier.setaddress("NH33,Chennai");
				
			  boolean status = 	supplierDAO.save(supplier);
			  assertEquals("save supplier test case", true, status);
			}
			
			
			@Test
			public void updateSupplierTestCase()
			{
				supplier =new Supplier();
				supplier.setId("SUP-001");
				supplier.setName("BigC");
				supplier.setaddress("warli, Mumbai");
				boolean status = supplierDAO.update(supplier);
				assertEquals("update test case", true,status );
			}
			
			@Test
			public void getSupplierSuccessTestCase()
			{
				supplier= supplierDAO.get("jaskaran1@gmail.com");
				
				assertNotNull("get supplier test case", supplier);
				}
				
				@Test
				public void getSupplierFailureTestCase()
				{
					
				supplier= supplierDAO.get("SUP-001");
				
				assertNull("get supplier test case", supplier);
				}
				
				@Test
				public void deleteSupplierSuccessTestCase()
				{
				boolean status =	supplierDAO.delete("jaskaran1@gmail.com");
				assertEquals("delete supplier succss test case" , true, status);
				
				}
				@Test
				public void deleteSupplierFailureTestCase()
				{
				boolean status =	supplierDAO.delete("arpith@gmail.com");
				assertEquals("delete supplier failure test case" , false, status);
				
				}
				
				
				@Test
				public void getAllSuppliersTestCase()
				{
				List<Supplier>	suppliers = supplierDAO.list();
				assertEquals("get all usres " , 3, suppliers.size() );
				
				}
				
			}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
