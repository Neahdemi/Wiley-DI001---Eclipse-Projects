package com.neah.service;

import java.util.Collection;
import java.util.List;

import com.neah.entity.Employee;
import com.neah.entity.EmployeePaySlip;

public interface EmployeeService {

	Collection<Employee> getAllEmployees();
	
	Employee searchEmployeeById(int id);
	
	boolean addEmployee(Employee employee);
	
	boolean deleteEmployee(int id);
	
	boolean incrementSalary(int id,double increment);
	
	EmployeePaySlip generatePaySlip(int employeeId);
}