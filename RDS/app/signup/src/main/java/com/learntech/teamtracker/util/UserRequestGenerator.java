package com.learntech.teamtracker.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntech.teamtracker.model.User;

/**
 * @author UthirNew
 *
 */
public class UserRequestGenerator {

	/**
	 * @param args
	 * @throws JsonProcessingException 
	 */
	public static void main(String[] args) throws JsonProcessingException {
		
		ObjectMapper objMapper = new ObjectMapper();
		
		User user = new User();
		
		user.setEmailId("mytestrds@gmail.com");
		user.setUserName("uthirdev");
		user.setPassword("uthirdev");
		
		System.out.println(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));

	}

}
