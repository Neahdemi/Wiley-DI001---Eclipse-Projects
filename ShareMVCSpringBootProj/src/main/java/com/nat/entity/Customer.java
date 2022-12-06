package com.nat.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer2")
public class Customer {

	@Id
	private int detailId;
	private int customerId;
	private int shareId;
	private String shareType;
	private int quantity;
	
	
	
}
