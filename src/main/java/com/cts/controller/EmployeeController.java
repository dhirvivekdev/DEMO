package com.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	/*
	 * use postman to send request
	 * 
	 * select get method
	 * type URL ==> http://localhost:9090/employees/allemp
	 */
	@GetMapping("/allemp")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	
	/*
	 * use postman to send request
	 * 
	 * select get method
	 * type URL ==> http://localhost:9090/employees/1001
	 */
	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable int id) {
		return service.getEmployeeById(id);
				
	}
	
	/*
	 * use postman to send request
	 * 
	 * select post method
	 * type URL ==> http://localhost:9090/employees/add
	 * then select body -> raw->json then type complete object data in json given format
	 {
    "id": 2001,
    "name": "Shyiam",
    "gender": "Male",
    "age": 24,
    "salary": 25000.0,
    "city": "Bangalore",
    "dateOfJoining": "2019-06-25"
}
	 
	 */
	
	@PostMapping("/add")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		
		return service.addEmployee(employee);
	}
	
	/*
	 * use postman to send request
	 * 
	 * select delete method
	 * type URL ==> http://localhost:9090/employees/delete/1001
	 */
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id){
		
		return service.deleteEmployee(id);
	}
	
	/*
	 * use postman to send request
	 * 
	 * select put method
	 * type URL ==> http://localhost:9090/employees/update/2001
	 * then select body -> raw->json then type complete object data in json given format
	 {
    "id": 2001,
    "name": "Shyiam",
    "gender": "Male",
    "age": 25,
    "salary": 35000.0,
    "city": "Pune",
    "dateOfJoining": "2019-06-25"
}
	 
	 */
	
	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
		
		return service.updateEmployee(id, employee);
				
	}
	
	/*
	 * use postman to send request
	 * 
	 * select get method
	 * type URL ==> http://localhost:9090/employees/salary/30000/50000
	 */
	
	@GetMapping("/salary/{lower}/{upper}")
	public List<Employee> getEmployeesBySalary(@PathVariable double lower,@PathVariable double upper){
		return service.getEmployeeBasedOnSalary(lower, upper);
	}
	
}
