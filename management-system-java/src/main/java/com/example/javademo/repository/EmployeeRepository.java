package com.example.javademo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javademo.models.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

	Optional<Employee> findByFirstName(String firstName);

	Optional<Employee> findByWorkLocation(String workLocation);

}
