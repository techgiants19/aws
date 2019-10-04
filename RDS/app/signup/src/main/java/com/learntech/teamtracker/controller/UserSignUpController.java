/**
 * 
 */
package com.learntech.teamtracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learntech.teamtracker.model.User;
import com.learntech.teamtracker.service.SignUpService;

/**
 * @author UthirNew
 *
 */
@RestController
public class UserSignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserSignUpController.class);
	
	private static final String SIGNUP_HOME = "signuphome";
	private static final String SIGNUP      = "signup";
	
	
	private SignUpService signUpService;
	
	public UserSignUpController(SignUpService signUpService) {
		this.signUpService = signUpService;
	}

	@GetMapping(name=SIGNUP_HOME)
	public String singnUpUser(@RequestParam(name="username") String userName){
		
		logger.info("entered in singnUpUser()");
		return "Welcome to SignUp Page";
	}
	
	@PostMapping(value=SIGNUP)
	public User singnUpUser(@RequestBody User user){
		return signUpService.userSignUp(user);
	}

}
