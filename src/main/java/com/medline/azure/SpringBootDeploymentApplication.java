package com.medline.azure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDeploymentApplication {

	@GetMapping("/")
	public String welcome() {
		return "Welcome to fist project after commit";
	}

	@GetMapping("/hello")
	public String hello(String name) {
 		return "hello "+name==null?"User":name;
	}
 	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDeploymentApplication.class, args);
	}

}
