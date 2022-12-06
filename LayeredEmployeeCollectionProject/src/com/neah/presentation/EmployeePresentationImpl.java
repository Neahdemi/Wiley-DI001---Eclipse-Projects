package com.neah.presentation;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collection;
import java.util.List;

import com.neah.entity.Employee;
import com.neah.entity.EmployeePaySlip;
import com.neah.service.EmployeeService;
import com.neah.service.EmployeeServiceImpl;

public class EmployeePresentationImpl implements EmployeePresentation {

	//Presentation will pass the request to service for processing and gives response to client
	private EmployeeService employeeService=new EmployeeServiceImpl();
	
	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Employee Management System");
		System.out.println("1. List All Employees");
		System.out.println("2. Search Employee By ID");
		System.out.println("3. Add New Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Increment Salary");
		System.out.println("6. Generate PaySlip");
		System.out.println("7. Search Employees By Department");
		System.out.println("8. Exit");
		System.out.println("============================");

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
		switch (choice) {
		case 1:
			Collection<Employee> employees=employeeService.getAllEmployees();
			for(Employee emp:employees) {
				System.out.println(emp);
			}
			break;
		case 2:
			System.out.println("Enter Employee ID : ");
			int id=scanner.nextInt();
			Employee employee=employeeService.searchEmployeeById(id);
			if(employee!=null)
				System.out.println(employee);
			else
				System.out.println("Employee with id "+id+" does not exist");
			break;
		case 3:
			Employee newEmployee=new Employee();
			
			System.out.println("Enter Employee id : ");
			newEmployee.setEmpId(scanner.nextInt());
			System.out.println("Enter Employee Name : ");
			newEmployee.setEmpName(scanner.next());
			System.out.println("Enter Employee Designation : ");
			newEmployee.setEmpDesignation(scanner.next());
			System.out.println("Enter Employee Department : ");
			newEmployee.setEmpDepartment(scanner.next());
			System.out.println("Enter Employee Salary : ");
			newEmployee.setEmpSalary(scanner.nextDouble());
			System.out.println("Enter Employee Date of joining (dd-Mon-yyyy) : ");
			DateTimeFormatter df=new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("d-MMM-yyyy")).toFormatter();
			
			newEmployee.setDateOfJoining(LocalDate.parse(scanner.next(),df));
			
			if(employeeService.addEmployee(newEmployee))
				System.out.println("Employee Record Added");
			else
				System.out.println("Employee with id "+newEmployee.getEmpId()+" already exist, so cannot add it as a new employee!");
			
			break;
		case 4:
			System.out.println("Enter Employee ID : ");
			int eId=scanner.nextInt();
			if(employeeService.deleteEmployee(eId))
				System.out.println("Employee with id "+eId+" deleted");
			else
				System.out.println("Employee with id "+eId+" does not exist");
			break;
		case 5:
			System.out.println("Enter Employee ID : ");
			int empId=scanner.nextInt();
			System.out.println("Enter Increment Amount : ");
			double increment=scanner.nextDouble();
			if(employeeService.incrementSalary(empId, increment))
				System.out.println("Employee with Id "+empId+" salary incremented with amount "+increment);
			else
				System.out.println("Employee with ID "+empId+" does not exist");
			break;
		case 6:
			System.out.println("Enter Employee ID : ");
			int employeeId=scanner.nextInt();
			EmployeePaySlip payslip=employeeService.generatePaySlip(employeeId);
			if(payslip!=null)
				System.out.println(payslip);
			else
				System.out.println("Employee with id "+employeeId+" does not exist!");
			break;
		case 7:
			System.out.println("Enter Employee Department : ");
			String department = scanner.next();
			List<Employee> emps = employeeService.employeeByDepartment(department);
			if (emps !=null) {
				System.out.println(emps);
			}else {
				System.out.println("Employee department " + department + " does not exist");
			}
			break;
		case 8:
			System.out.println("Thanks for using Employee Management System");
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");
			break;
		}

	}

}