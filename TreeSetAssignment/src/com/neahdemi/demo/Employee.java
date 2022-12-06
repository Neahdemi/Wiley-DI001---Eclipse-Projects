package com.neahdemi.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Employee implements Comparable <Employee>{
	
	
	private String id, name, designations, department;
	private int  experience;
	private double salary;
	
	/*
	 * TreeSet will be using compareTo to arrange objects in ascending order and will store unique
	 * if object1 (this) is greater return :1
	 * if object2(argument) is greater return : -1
	 * if both objects are equal : 0
	 */
	@Override
	public int compareTo(Employee employee2) {
		if(experience>employee2.experience)
			return 1;
		else if(experience < employee2.experience)
			return -1;
		else if(this.equals(employee2))
			return 0;
		return 1;
		
	}	

}
