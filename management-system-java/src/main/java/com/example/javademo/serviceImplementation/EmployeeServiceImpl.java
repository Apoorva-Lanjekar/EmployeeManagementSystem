package com.example.javademo.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import com.example.javademo.exception.EmployeeAlreadyExistsException;
import com.example.javademo.exception.EmployeeNotFoundException;
import com.example.javademo.models.Employee;
import com.example.javademo.repository.EmployeeRepository;
import com.example.javademo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		if(this.employeeRepository.existsById((long) employee.getId())) {
			throw new EmployeeAlreadyExistsException("Employee already exists");
		}
		return this.employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(long id) throws EmployeeNotFoundException{
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Employee findEmployeebyId(long id) throws EmployeeNotFoundException{
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new EmployeeNotFoundException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public Employee findEmployeebyName(String name) throws EmployeeNotFoundException{
		Optional<Employee> optional = employeeRepository.findByFirstName(name);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new EmployeeNotFoundException(" Employee not found for name :: " + name);
		}
		return employee;
	}
	
	@Override
	public Employee findEmployeebyWorkLocation(String location) throws EmployeeNotFoundException{
		Optional<Employee> optional = employeeRepository.findByWorkLocation(location);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new EmployeeNotFoundException(" Employee not found for location :: " + location);
		}
		return employee;
	}


}
