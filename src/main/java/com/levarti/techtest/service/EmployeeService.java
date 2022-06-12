package com.levarti.techtest.service;

import java.util.List;

import com.levarti.techtest.model.Employee;


/**
 * @author Mahesh
 * @version 1.0 
 * EmployeeService Interface
 * */

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public void saveOrUpdate(Employee employee);

	public void delete(int id);
}
