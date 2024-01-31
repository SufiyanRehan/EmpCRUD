package com.crudOperations.service;

import java.util.List;

import com.crudOperations.model.Employee;

public interface EmployeeService {

	
	List<Employee> fetchAllEmployees();
	
	public Employee getEmployeeById(Long id);
	
	public Employee saveEmployee(Employee employee);
	
	public Employee updateEmpById(Long id,Employee employee);
	
	public String deleteEmpById(Long id);
	
}
