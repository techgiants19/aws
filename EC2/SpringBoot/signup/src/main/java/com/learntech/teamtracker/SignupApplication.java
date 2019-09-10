package com.learntech.teamtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.learntech.teamtracker"})
public class SignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignupApplication.class, args);
	}

}
