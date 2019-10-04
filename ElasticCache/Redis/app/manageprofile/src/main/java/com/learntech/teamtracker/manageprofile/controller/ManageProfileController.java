/**
 * 
 */
package com.learntech.teamtracker.manageprofile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learntech.teamtracker.manageprofile.model.UserProfile;
import com.learntech.teamtracker.manageprofile.repository.UserProfileRepository;
import com.learntech.teamtracker.manageprofile.service.ManageProfileService;

/**
 * @author UthirNew
 *
 */
@RestController
public class ManageProfileController {
	
	public static final Logger logger = LoggerFactory.getLogger(ManageProfileController.class);
	
	private ManageProfileService manageProfileService;
	
	public ManageProfileController(ManageProfileService manageProfileService
			                       ) throws Exception {
		super();
		this.manageProfileService  = manageProfileService;
	}



	@PostMapping(path="/userprofile")
	public UserProfile insertUserProfile(@RequestBody(required=true) UserProfile userProfile) throws Exception{
		logger.info("insertUserProfile() Starts");
		
		UserProfile userProfileInsert = manageProfileService.insertUserProfileInfo(userProfile);
		
		logger.info("insertUserProfile() Ends");
		return userProfileInsert;
	}
	
	@GetMapping(path="/userprofile")
	public UserProfile getUserProfile(@RequestParam(name="emailid",required=true) String emailId) throws Exception{
		return manageProfileService.getUserProfileInfo(emailId);
	}

}
