package com.lti.dao;

import com.lti.model.Emi;
import com.lti.model.Login;
import com.lti.model.Product;

public interface FinanaceManagementDao {
	public int createCustomer(Login login);
	public Login viewUser(String username);
	
	public Product viewProduct(String productName);
	public int insertNewEmi(Emi emi);
		
}
