package com.neah.resource;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neah.entity.Employee;
import com.neah.entity.EmployeePaySlip;
import com.neah.model.service.EmployeeService;

@RestController
public class EmployeeResource {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(path = "/employees",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public Collection<Employee> getAllEmployeesResource(){
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(path = "/employees/{eid}",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public Employee searchEmployeeByIdResource(@PathVariable("eid") int id) {
		return employeeService.searchEmployeeById(id);
	}
	
	@RequestMapping(path = "/employees/employeepayslip/{eid}",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public EmployeePaySlip generatePayslipResource(@PathVariable("eid")int id) {
		return employeeService.generatePaySlip(id);
		
	}
	
	@RequestMapping(path = "/employees/desig/{designation}",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> searchByDesignationResource(@PathVariable("designation")String designation){
		return employeeService.searchByDesignation(designation);
	}
	
    @RequestMapping(path = "/employees/dep/{department}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployeeByDepartmentResource(@PathVariable("department") String department) {
        return employeeService.getEmployeesByDepartment(department);
    }
	
}