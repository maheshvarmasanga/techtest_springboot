package com.levarti.techtest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levarti.techtest.exception.EmployeeNotFoundException;
import com.levarti.techtest.exception.NoDataFoundException;
import com.levarti.techtest.model.Employee;
import com.levarti.techtest.repository.EmployeeRepository;
import com.levarti.techtest.service.EmployeeService;

/**
 * @author Mahesh
 * @version 1.0 
 * An implementation service class for interface EmployeeService 
 * */



@Service
public class DefaultEmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultEmployeeServiceImpl.class);
	
	@Autowired
	private  EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		logger.info("Returning available employees records...");
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employee -> employees.add(employee));
		
		if(employees.isEmpty()) {
			   throw new NoDataFoundException();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		logger.info("loading employee record with id: " + id);
		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException(id);
		}
		return employee.get();

	}

	@Override
	public void saveOrUpdate(Employee employee) {
		logger.info("Saving new employee record with id: " + employee.getId());
		employeeRepository.save(employee);
		
	}

	/*
	 * In real time, this will set the record's active flag to zero/false, updatedBy
	 * and updated timestamp fields to the current timestamp to indicate the record has been deactivated.
	 */
	@Override
	public void delete(int id) {
		logger.info("Deleting employee record with id: " + id);
		employeeRepository.deleteById(id);
	}

}
