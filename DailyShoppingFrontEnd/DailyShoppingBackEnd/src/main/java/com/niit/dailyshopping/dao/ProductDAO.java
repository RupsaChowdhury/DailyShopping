package com.niit.dailyshopping.dao;

import java.util.List;

import com.niit.dailyshopping.domain.Product;






public interface ProductDAO {
	
	
	public boolean save(Product user);
	
	

	
	public boolean update(Product user);
	
	
	
		public   Product     get(String Id);
		
		
	
		
		public   boolean    delete(String Id);
		
	
		public List<Product>   list();
		
		
		
		
		
}
