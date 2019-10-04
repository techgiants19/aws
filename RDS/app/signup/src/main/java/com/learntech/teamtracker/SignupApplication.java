package com.learntech.teamtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.learntech.teamtracker"})
@EnableJpaRepositories(basePackages="com.learntech.teamtracker.repository")
public class SignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignupApplication.class, args);
	}

}
