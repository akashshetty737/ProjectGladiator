package com.lti.controller;

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

import com.lti.model.Emi;
import com.lti.model.Login;
import com.lti.model.Product;
import com.lti.service.FinanaceManagementService;

@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class FinanceManagementController {

	@Autowired
	private FinanaceManagementService service;

	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addCustomer(@RequestBody Login login){
		ResponseEntity<String> response;
		boolean result = service.addCustomer(login);
		if(result){
			response=new ResponseEntity<String>("Customer IS ADDED",HttpStatus.CREATED);
		}
		else{
			response=new ResponseEntity<String>("Customer IS NOT ADDED.",HttpStatus.INTERNAL_SERVER_ERROR);
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
		
		@RequestMapping(path="products/buy", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> addNewEmi(@RequestBody Emi emi){
			ResponseEntity<String> response;
			boolean result = service.addNewEmi(emi);
			if(result){
				response=new ResponseEntity<String>("Product Purchased",HttpStatus.CREATED);
			}
			else{
				response=new ResponseEntity<String>("Some Error Occured. Please Try Again",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return response;
		}	
	
/*	@RequestMapping(path="products/{productName}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public void productDisplay(@PathVariable("productName") String productName) {
		System.out.println(productName);
		
	}*/

	/*	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addCustomer(@RequestBody Login login){
		System.out.println(login);
		System.out.println(login.getCustomer());
	}*/

}
