package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Customer;
import com.lti.model.Login;
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
	
	
}
