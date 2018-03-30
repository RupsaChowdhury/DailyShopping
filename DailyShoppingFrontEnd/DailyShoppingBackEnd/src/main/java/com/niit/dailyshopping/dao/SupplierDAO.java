package com.niit.dailyshopping.dao;

import java.util.List;

import com.niit.dailyshopping.domain.Supplier;






public interface SupplierDAO {
	

	
	public boolean save(Supplier user);
	
	
	
	
	public boolean update(Supplier user);
	
	
	
		public   Supplier  get(String Id);
		
		
		
		
		public   boolean    delete(String Id);
		
		
		public List<Supplier>   list();
		

	
	
		
		
		
		//we may require more methods...will discuss
		
		
		
}
