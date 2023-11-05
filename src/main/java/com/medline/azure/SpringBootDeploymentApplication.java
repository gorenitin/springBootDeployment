package com.medline.azure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RestController
@Slf4j
public class SpringBootDeploymentApplication {

	@Autowired
	EmployeeRepo empRepo;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to fist project after commit";
	}

	@GetMapping("/hello")
	public String hello(String name) {
 		return "hello "+(name==null?"User":name);
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee (@RequestBody Employee employee) {
 		log.debug("Sample debug");
		return empRepo.save(employee);
 	}

	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees () {
 		return empRepo.findAll();
 	}

	@GetMapping("/getEmployee")
	public Employee getEmployee (int id) {
 		return empRepo.findById(id).get();
 	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDeploymentApplication.class, args);
	}

}
