package com.neahdemi.demo;

import java.util.Set;
import java.util.TreeSet;

public class EmployeeMain {

	public static void main(String[] args) {

		
		Set<Employee> employee = new TreeSet<Employee>();
		
		System.out.println("Size: " + employee.size());
		employee.add(new Employee("1a", "AAAA", " Executive", "IT", 12, 12345.00));
		employee.add(new Employee("1b", "BBBB", " Manager", "Marketing", 4, 123455.00));
		employee.add(new Employee("1c", "CCCC", "Sr. Executive", "IT", 8, 12345.00));
		employee.add(new Employee("1d", "DDDD", " Associate", "Buying", 7, 122345.00));
		employee.add(new Employee("1e", "EEEE", " Sr. Manager", "Sales", 10, 1243345.00));
		
		System.out.println(employee.toString());
		

	}

}
