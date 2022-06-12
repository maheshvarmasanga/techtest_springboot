package com.levarti.techtest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.levarti.techtest.exception.EmployeeNotFoundException;
import com.levarti.techtest.model.Employee;
import com.levarti.techtest.service.impl.DefaultEmployeeServiceImpl;

/**
 * @author Mahesh Sanga
 * @version: 2.0
 * 
 *    Controller class.
 */

@RestController
public class EmployeeController {
	@Autowired
	DefaultEmployeeServiceImpl employeeService;

	@GetMapping("/employees")
	private List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	private Employee getEmployeeById(@PathVariable("id") int id) {

		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/employees/create")
	private ResponseEntity createEmployee(@RequestBody @Valid Employee employee) {
		try {
			employeeService.saveOrUpdate(employee);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity("New employee created with id: " + employee.getId(), HttpStatus.CREATED);
	}

	@DeleteMapping({ "employees/delete/{id:\\d+}" })
	private ResponseEntity deleteById(@PathVariable("id") int id) {
		try {
			employeeService.delete(id);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity("Employee deleted with id: " + id, HttpStatus.OK);
	}
}
