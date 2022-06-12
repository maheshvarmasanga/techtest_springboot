package com.levarti.techtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.levarti.techtest.model.Employee;

/**
 * @author Mahesh
 * @version 1.0 
 * EmployeeRepository Interface
 * */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
