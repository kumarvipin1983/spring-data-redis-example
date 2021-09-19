package com.javatechie.spring.mokito.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.spring.mokito.api.model.Employee;

@Repository 
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
	
}
