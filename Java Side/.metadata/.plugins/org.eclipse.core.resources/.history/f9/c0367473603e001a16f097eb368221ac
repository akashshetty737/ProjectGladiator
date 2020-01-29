package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.FinanaceManagementDao;
import com.lti.model.Customer;

@Service("service")
public class FinanceManagementServiceImpl implements FinanaceManagementService {

	@Autowired
	FinanaceManagementDao dao;
	
	@Override
	public boolean addCustomer(Customer customer) {
		int result = dao.createCustomer(customer);
		
		if(result == 1){
			return true;
		}
		else{
			return false;
		}
	
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
