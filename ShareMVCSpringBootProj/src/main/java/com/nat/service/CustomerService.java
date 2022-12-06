package com.nat.service;

import java.util.List;

import com.nat.entity.Customer;

public interface CustomerService {

	public List<Customer> searchCustomerByCustomerId(int customerId);
}
