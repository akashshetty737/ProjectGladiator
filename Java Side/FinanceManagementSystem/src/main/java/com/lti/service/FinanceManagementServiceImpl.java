package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.FinanaceManagementDao;
import com.lti.model.Customer;
import com.lti.model.Emi;
import com.lti.model.EmiPayment;
import com.lti.model.Login;
import com.lti.model.Product;

@Service("service")
public class FinanceManagementServiceImpl implements FinanaceManagementService {

	@Autowired
	FinanaceManagementDao dao;
	
	@Override
	public boolean addCustomer(Login login) {
		int result = dao.createCustomer(login);
		
		if(result == 1){
			return true;
		}
		else{
			return false;
		}
	
	}

	@Override
	public Login findUser(String username) {
		return  dao.viewUser(username);
	}

	@Override
	public Product showProduct(String productName) {
	
		return dao.viewProduct(productName);
	}

	@Override
	public List<Product> showAllProduct() {
			return dao.viewAllProduct();
	}
	@Override
	public boolean addNewEmi(Emi emi) {
		int result = dao.insertNewEmi(emi);
		if(result == 1){
			return true;
		}else{
			return false;
		}
			
	}

	@Override
	public List<Customer> showAllCustomers() {
		
		return dao.viewAllCustomer();
	}

	@Override
	public List<Emi> showAllEmiForCustomer(int customerId) {
		
		return dao.viewAllEmiForCustomer(customerId);
	}

	public boolean addPayment(EmiPayment emiPayment){
		double result=dao.insertPayment(emiPayment);
		
		if(result==1){
			return true;
		}
		else{
			return false;
		}
	}
	

}
