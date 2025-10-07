package com.cts.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findEmployeeBySalaryBetween(double lower,double upper);
	
}
