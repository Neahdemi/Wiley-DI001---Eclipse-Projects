package com.neah.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neah.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public Customer findByAccountIdAndAccountPassword(int accountId, String accountPassword);
	
}