package com.neah.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@Column(name = "account_ID")
	private int accountId;
	
	@Column(name = "account_password")
	private String accountPassword; 
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_address")
	private String customerAddress;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "bank_balance")
	private double balance;
	
	
	
}