package com.lti.service;

import java.util.List;

import com.lti.model.Customer;
import com.lti.model.Emi;
import com.lti.model.EmiPayment;
import com.lti.model.Login;
import com.lti.model.Product;

public interface FinanaceManagementService {
	
	public boolean addCustomer(Login login);
	public Login findUser(String username);
	
	public Product showProduct(String productName);
	public List<Product> showAllProduct();
	public List<Customer> showAllCustomers();
	public boolean addNewEmi(Emi emi);
	
	public List<Emi> showAllEmiForCustomer(int customerId);
	public boolean addPayment(EmiPayment emi_payment);

}
