package com.crudOperations.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperations.model.Employee;
import com.crudOperations.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> fetchAllEmployees() {

		List<Employee> allEmployees = employeeRepository.findAll();
		return allEmployees;
	}

	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee =  employeeRepository.findById(id);
	
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Employee updateEmpById(Long id, Employee employee) {
		
		Optional<Employee> emp1= employeeRepository.findById(id);
		if(emp1.isPresent()) {
			
			Employee emp2 = emp1.get();

			if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
				emp2.setEmployeeName(employee.getEmployeeName());
            }
			if (Objects.nonNull(employee.getEmployeeSalary()) && employee.getEmployeeSalary() != 0) {
			emp2.setEmployeeSalary(employee.getEmployeeSalary());
			}		
		return employeeRepository.save(emp2);
		}
		return null;
	}

	@Override
	public String deleteEmpById(Long id) {
			if(employeeRepository.findById(id).isPresent())
			{
				employeeRepository.deleteById(id);
			return "Emp Record Deleted";
			}
		
		return "Emp Not Found Please put correct Id";
	}

	
}
