package com.neah.model.service;

import com.neah.entity.Customer;

public interface LoginService {

	boolean loginCheck(Customer customer);
	
	Customer transferFunds(int myAccountId,int recepientAccountId,double amount);
	
}
