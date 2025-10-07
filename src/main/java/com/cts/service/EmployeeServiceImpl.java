package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.EmployeeException;
import com.cts.model.Employee;
import com.cts.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public List<Employee> getEmployees() {
			return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
			return repo.findById(id).
				orElseThrow(()->new EmployeeException("Employee with the id "+id+" does not exist"));
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Optional<Employee> op=repo.findById(employee.getId());
		if(op.isPresent()) {
			throw new EmployeeException("Employee with the Id "+employee.getId()+" already exist");
		}
		repo.save(employee);
		return employee;
	}

	@Override
	public String deleteEmployee(int id) {
		Optional<Employee> empOpt=repo.findById(id);
		if(!empOpt.isPresent()) {
			throw new EmployeeException("Employee with the id "+id+" does not exist");
		}
		repo.deleteById(id);
		return "Employee with the Id "+id+" deleted successfully";
	}

	@Override
	public String updateEmployee(int id, Employee employee) {
		Optional<Employee> op=repo.findById(id);
		if(!op.isPresent()) {
			throw new EmployeeException("Employee with the Id "+id+" does not exist");
		}
		Employee emp=op.get();
		if(employee.getName()!=null) {
			
			emp.setName(employee.getName());
		}
		if(employee.getGender()!=null) {
			emp.setGender(employee.getGender());
		}
		if(employee.getAge()!=0) {
			emp.setAge(employee.getAge());
		}
		if(employee.getSalary()!=0) {
			emp.setSalary(employee.getSalary());
		}
		if(employee.getCity()!=null) {
			emp.setCity(employee.getCity());
		}
		if(employee.getDateOfJoining()!=null) {
			emp.setDateOfJoining(employee.getDateOfJoining());
		}
		repo.save(emp);
		return "Employee with the id "+id+" updated successfully";
	}

	@Override
	public List<Employee> getEmployeeBasedOnSalary(double lower, double upper) {
			return repo.findEmployeeBySalaryBetween(lower, upper);
	}

}
