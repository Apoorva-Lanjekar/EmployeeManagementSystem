package com.example.javademo.service;

import java.util.List;
import java.util.Optional;

import com.example.javademo.exception.EmployeeAlreadyExistsException;
import com.example.javademo.exception.EmployeeNotFoundException;
import com.example.javademo.models.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees() throws EmployeeNotFoundException;
	Employee saveEmployee(Employee employee) throws EmployeeAlreadyExistsException;
	void deleteEmployeeById(long id) throws EmployeeNotFoundException;
	Employee findEmployeebyId(long Id) throws EmployeeNotFoundException;
	Employee findEmployeebyName(String name) throws EmployeeNotFoundException;
	Employee findEmployeebyWorkLocation(String location) throws EmployeeNotFoundException;
}
