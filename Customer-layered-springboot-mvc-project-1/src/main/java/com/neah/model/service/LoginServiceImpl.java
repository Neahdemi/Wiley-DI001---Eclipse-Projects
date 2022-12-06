package com.neah.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neah.entity.Customer;
import com.neah.model.persistence.CustomerDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	public boolean loginCheck(Customer customer) {
		try {
			Customer cusomer = customerDao.findByAccountIdAndAccountPassword(customer.getAccountId(), customer.getAccountPassword());
		
			if(cusomer != null)
				return true;
			return false;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public Customer transferFunds(int myAccountId, int recepientAccountId, double amount) {
		Customer customer=customerDao.findById(myAccountId).get();
		if(customer.getBalance()<amount)
			return null;
		else {
			Customer recepient=customerDao.findById(recepientAccountId).orElse(null);
			if(recepient!=null) {
				recepient.setBalance(recepient.getBalance()+amount);
				customer.setBalance(customer.getBalance()-amount);
				customerDao.save(recepient);
				customerDao.save(customer);
				return customer;
			}
			else
				return null;
			
		}

	}

}