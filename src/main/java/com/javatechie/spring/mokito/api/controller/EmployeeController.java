package com.javatechie.spring.mokito.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mokito.api.model.Employee;
import com.javatechie.spring.mokito.api.model.Response;
import com.javatechie.spring.mokito.api.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository; 
	
	@PostMapping("/addEmployee")
	public Response addEmployee(@RequestBody Employee emp) {
		repository.save(emp);
		return new Response(emp.getId()+ "inserted", Boolean.TRUE);
	}
	
	@GetMapping
	public Response getAllEmployees() {
		List<Employee> employees =  repository.findAll();
		return new Response("records counts : " + employees.size(), Boolean.TRUE);
	}
}
