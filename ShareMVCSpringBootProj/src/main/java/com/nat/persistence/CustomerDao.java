package com.nat.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	public List<Customer> searchCustomerByCustomerId(int customerId);
	

}
