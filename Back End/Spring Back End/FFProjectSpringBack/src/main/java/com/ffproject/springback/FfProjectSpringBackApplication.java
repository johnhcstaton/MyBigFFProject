package com.ffproject.springback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping({"/api/ffproject"})
public class FfProjectSpringBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FfProjectSpringBackApplication.class, args);
	}

	@GetMapping({"/test/testEndpoint"})
	public String testEndpoint() {
		return "test";
	}

}
