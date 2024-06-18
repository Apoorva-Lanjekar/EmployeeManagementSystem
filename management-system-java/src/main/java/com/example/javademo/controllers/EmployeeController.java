package com.example.javademo.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javademo.exception.EmployeeAlreadyExistsException;
import com.example.javademo.exception.EmployeeNotFoundException;
import com.example.javademo.models.Employee;
import com.example.javademo.serviceImplementation.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping("/employees")
	public ResponseEntity<List<Employee>> createEmployees(List<Employee> employees) {
		List<Employee> employeeResult = new ArrayList<Employee>();
		try {
			if (!CollectionUtils.isEmpty(employees)) {
				for (Employee employee : employees) {					
					employeeResult.add(employeeServiceImpl.saveEmployee(employee));			
				}
			}
		} catch( EmployeeAlreadyExistsException e) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(employeeResult);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		try {
			return ResponseEntity.ok(employeeServiceImpl.getAllEmployees());
		} catch(EmployeeNotFoundException e ) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/employeesById/{id}") //Changed /employees to /employeesById for ambibuity issue
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String empID) {
		Employee emp = null;
		try {
			emp = this.employeeServiceImpl.findEmployeebyId(Long.parseLong(empID));
		} catch (EmployeeNotFoundException e) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(emp);
	}

	@GetMapping("/employeesByName/{byName}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable("byName") String name) {
		Employee emp = null;
		try {
			emp = this.employeeServiceImpl.findEmployeebyName(name);
		} catch (EmployeeNotFoundException e) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(emp);
	}	
	
	@GetMapping("/employeesByLocation/{byWorkLocation}")
	public ResponseEntity<Employee> getEmployeesByWorkLocation(@PathVariable("byWorkLocation") String location) {
		Employee emp = null;
		try {
			emp = this.employeeServiceImpl.findEmployeebyName(location);
		} catch (EmployeeNotFoundException e) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(emp);
	}	
	
}
