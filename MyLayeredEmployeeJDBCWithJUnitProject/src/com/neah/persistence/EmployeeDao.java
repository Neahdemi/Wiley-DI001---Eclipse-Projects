package com.neah.persistence;

import java.util.Collection;
import java.util.List;

import com.neah.entity.Employee;

/*
 * DAO : Data Access Object : Design Pattern to design persistence layer
 */
public interface EmployeeDao {

	Collection<Employee> getAllRecords();
	Employee searchRecord(int id);
	int insertRecord(Employee employee);
	int deleteRecord(int id);
	int updateSalary(int id,double increment);
}