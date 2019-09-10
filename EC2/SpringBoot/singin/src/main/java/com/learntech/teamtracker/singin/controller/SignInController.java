/**
 * 
 */
package com.learntech.teamtracker.singin.controller;

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
public class SignInController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignInController.class);
	
	@GetMapping(name="/signin")
	public String singIn(@RequestParam(name="username") String userName){
		logger.info("entered singIn()");
		return "This is SignInController";
	}

}
