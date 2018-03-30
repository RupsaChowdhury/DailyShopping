package com.niit.dailyshopping.dao;

	import java.util.List;

import com.niit.dailyshopping.domain.User;





	
	public interface UserDAO {
		
	
		
		public boolean save(User user);
		
		
		
		
		public boolean update(User user);
		
		
		
			public   User     get(String emailID);
			
			

			
			public   boolean    delete(String emailID);
			
		
			public List<User>   list();
			
	
		
			public    User      validate(String emailID, String password);
			
			
		
			
		

}
