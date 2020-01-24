package com.lti.service;

import java.util.List;

import com.lti.model.Customer;
import com.lti.model.Login;

public interface FinanaceManagementService {
	
	public boolean addCustomer(Login login);
	public List<Customer> findAllCustomer();
	

}
