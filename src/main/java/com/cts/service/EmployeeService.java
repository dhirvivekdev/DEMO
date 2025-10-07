package com.cts.service;

import java.util.List;

import com.cts.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();
	Employee getEmployeeById(int id);
	Employee addEmployee(Employee employee);
	String deleteEmployee(int id);
	String updateEmployee(int id,Employee employee);
	List<Employee> getEmployeeBasedOnSalary(double lower,double upper);
}
