package com.levarti.techtest.exception;

/**
 * @author Mahesh Sanga
 */
/*
 * @ResponseStatus(value = HttpStatus.NOT_FOUND) public class
 * EmployeeNotFoundException extends RuntimeException { public
 * EmployeeNotFoundException(int id) { super("Employee " + id + " not found!");
 * } }
 */

public class EmployeeNotFoundException extends RuntimeException
{
	public EmployeeNotFoundException(int id)
	{
		super("Employee " + id + " not found!");
	}
}
