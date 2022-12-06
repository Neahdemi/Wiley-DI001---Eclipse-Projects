package com.nat.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nat.entity.CustomerList;
import com.nat.service.CustomerService;

@RestController
public class CustomerResource {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path = "/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerList searchCustomerByCustomerIdResource(@PathVariable("customerId") int customerId) {
		
		return new CustomerList(customerService.searchCustomerByCustomerId(customerId));
		
		
	}
	
	
}
