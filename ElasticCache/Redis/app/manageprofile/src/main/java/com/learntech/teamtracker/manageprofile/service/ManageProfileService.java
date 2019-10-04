/**
 * 
 */
package com.learntech.teamtracker.manageprofile.service;

import com.learntech.teamtracker.manageprofile.model.UserProfile;

/**
 * @author UthirNew
 *
 */
public interface ManageProfileService {

	UserProfile insertUserProfileInfo(UserProfile userProfile) throws Exception;
	
	UserProfile getUserProfileInfo(String emailId) throws Exception;
}
