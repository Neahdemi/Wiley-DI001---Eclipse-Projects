package com.nat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nat.entity.Customer;
import com.nat.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	
	@Override
	public List<Customer> searchCustomerByCustomerId(int customerId) {
		return customerDao.searchCustomerByCustomerId(customerId);
	}

}
