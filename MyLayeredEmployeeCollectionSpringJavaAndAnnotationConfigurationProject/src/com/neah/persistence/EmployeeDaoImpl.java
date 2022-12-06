package com.neah.persistence;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.neah.database.EmployeeDataBase;
import com.neah.entity.Employee;


/*
 * If we don't specify component name,
 * then component name will be same as that of class name but in camelCase
 */
@Component("dao")
public class EmployeeDaoImpl implements EmployeeDao {

	
	
	@Override
	public Collection<Employee> getAllRecords() {
		return EmployeeDataBase.getEmployeeList().values();
	}

	@Override
	public Employee searchRecord(int id) {
		return EmployeeDataBase.getEmployeeList().get(id);
		
	}

	@Override
	public Employee insertRecord(Employee employee) {
		return EmployeeDataBase.getEmployeeList().put(employee.getEmpId(), employee);
	}

	@Override
	public Employee deleteRecord(int id) {
		
		return EmployeeDataBase.getEmployeeList().remove(id);
	}

}