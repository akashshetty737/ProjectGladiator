package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Customer;
import com.lti.model.Emi;
import com.lti.model.EmiPayment;
import com.lti.model.Login;
import com.lti.model.Product;
import com.lti.model.Response;
import com.lti.service.FinanaceManagementService;

@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class FinanceManagementController {

	@Autowired
	private FinanaceManagementService service;

	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> addCustomer(@RequestBody Login login){
		ResponseEntity<Response> response;
		boolean result = service.addCustomer(login);
		if(result){
			response=new ResponseEntity<Response>(new Response("Registration Successful"),HttpStatus.CREATED);
		}
		else{
			response=new ResponseEntity<Response>(new Response("Registration Not Successful. Please Try Again."),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@RequestMapping(path="{username}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Login loginCustomer(@PathVariable("username") String username) {
		Login login = service.findUser(username);
		return login;
	}
	
		@RequestMapping(path="products/{productName}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Product productDisplay(@PathVariable("productName") String productName) {
		Product product= service.showProduct(productName);
		return product;
	}
		//http://localhost:9090/products
		@RequestMapping(path="products", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Product> productAllDisplay() {
			List<Product> product= service.showAllProduct();
			return product;
	}
		
		//http://localhost:9090/admin
				@RequestMapping(path="admin", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
				public List<Customer> customerAllDisplay() {
					List<Customer> customer= service.showAllCustomers();
					return customer;
			}
			
		
		
		
		@RequestMapping(path="products/buy", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Response> addNewEmi(@RequestBody Emi emi){
			ResponseEntity<Response> response;
			boolean result = service.addNewEmi(emi);
			if(result){
				response=new ResponseEntity<Response>(new Response("Product Purchased"),HttpStatus.CREATED);
			}
			else{
				response=new ResponseEntity<Response>(new Response("Some Error Occured. Please Try Again"),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return response;
		}	
		
		
		@RequestMapping(path="emi/{customerId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Emi> emisByUserDisplay(@PathVariable("customerId") int customerId) {
			List<Emi> emi = service.showAllEmiForCustomer(customerId);
			return emi;
	}
		



		
}
