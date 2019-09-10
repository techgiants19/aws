/**
 * 
 */
package com.learntech.teamtracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author UthirNew
 *
 */
@RestController
public class UserSignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserSignUpController.class);
	
	@GetMapping(name="/signup")
	public String singnUpUser(@RequestParam(name="username") String userName){
		
		logger.info("entered in singnUpUser()");
		return "Welcome to SignUp Page";
	}

}
