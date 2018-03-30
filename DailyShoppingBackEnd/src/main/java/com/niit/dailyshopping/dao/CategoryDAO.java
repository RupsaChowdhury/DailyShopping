package com.niit.dailyshopping.dao;

import java.util.List;

import com.niit.dailyshopping.domain.Category;






public interface CategoryDAO {
	
	
	
	public boolean save(Category user);
	
	
	
	
	public boolean update(Category user);
	

	
		public   Category    get(String Id);
		
		
		
		
		public   boolean    delete(String Id);
		
		
		public List<Category>   list();
		
			
	
		
		
		
		
		//we may require more methods...will discuss
		
		
		
}
