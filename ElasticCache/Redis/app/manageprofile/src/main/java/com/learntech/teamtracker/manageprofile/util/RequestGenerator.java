/**
 * 
 */
package com.learntech.teamtracker.manageprofile.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntech.teamtracker.manageprofile.model.UserProfile;

/**
 * @author UthirNew
 *
 */
public class RequestGenerator {

	public static void main(String[] args) throws JsonProcessingException{
		
		UserProfile userProfile = new UserProfile();
		
		userProfile.setEmailId("myemail@gmail.com");
		userProfile.setFirstName("Rahul");
		userProfile.setLastName("Dravid");
		userProfile.setMiddleName("Sr");
		userProfile.setDob("1978-10-21");
		
		ObjectMapper objMapper = new ObjectMapper();
		System.out.println(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userProfile));
		
	}
}
