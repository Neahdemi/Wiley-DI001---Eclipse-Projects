package com.sujata.client;

import java.util.Collection;

import com.sujata.entity.Employee;
import com.sujata.service.EmployeeService;
import com.sujata.service.EmployeeServiceImpl;

public class tryingElse {

	public static void main(String[] args) {
		
		EmployeeService employeeService=new EmployeeServiceImpl();
		

		Collection<Employee> theEmps = employeeService.getEmployeesByDept("hs");
		System.out.println(theEmps);
	
		System.out.println(theEmps.size());
		//if(theEmps != null)
		//	for(Employee emp:theEmps) {
		//		System.out.println(theEmps);
		//	}
		//else 
		//	System.out.println("Department does not exist");

	}

}
