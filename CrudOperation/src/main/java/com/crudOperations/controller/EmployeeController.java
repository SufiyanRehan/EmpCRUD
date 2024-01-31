package com.crudOperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudOperations.model.Employee;
import com.crudOperations.service.EmployeeService;

@RestController
public class EmployeeController {

@Autowired
private EmployeeService  employeeService; 

//Insert new reocord
@PostMapping("/saveEmp")
public Employee saveEmployee(@RequestBody Employee employee) {
	return employeeService.saveEmployee(employee);
}

//Fetch all emp records
@GetMapping("/allEmp")
public List<Employee> getAllEmployees(){
	return employeeService.fetchAllEmployees();
}

//Used @RequestParam for get one emp 
@GetMapping("/employee/")
public Employee getEmployeeById(@RequestParam Long id) {
	return employeeService.getEmployeeById(id);
}

//Used @PathVariable for get one emp 
@GetMapping("/getEmp/{id}")
public Employee getEmpById(@PathVariable("id") Long id) {
	return employeeService.getEmployeeById(id);
}



//update records
@PutMapping("/employee/{id}")
public Employee updateEmpByid(@PathVariable("id") Long id,@RequestBody Employee employee  ) {
	
	return employeeService.updateEmpById(id,employee);
}

//Delete Record
@DeleteMapping("/employee/{id}")
public String deleteEmpById(@PathVariable ("id") Long id) {
	
	return employeeService.deleteEmpById(id);
}

}



