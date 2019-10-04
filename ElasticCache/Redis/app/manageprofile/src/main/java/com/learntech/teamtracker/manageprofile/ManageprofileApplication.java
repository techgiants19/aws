package com.learntech.teamtracker.manageprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.learntech.teamtracker.manageprofile"})
@EnableCaching
@EnableJpaRepositories(basePackages="com.learntech.teamtracker.manageprofile.repository")
public class ManageprofileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageprofileApplication.class, args);
	}

}
