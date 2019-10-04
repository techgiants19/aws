/**
 * 
 */
package com.learntech.teamtracker.manageprofile.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learntech.teamtracker.manageprofile.model.UserProfile;
import com.learntech.teamtracker.manageprofile.repository.UserProfileRepository;
import com.learntech.teamtracker.manageprofile.util.DateConverterUtil;

/**
 * @author UthirNew
 *
 */
@Service
public class ManageProfileServiceImpl implements ManageProfileService {

	private static final Logger logger = LoggerFactory.getLogger(ManageProfileServiceImpl.class);
	
	private UserProfileRepository userProfileRepository;
	
	public ManageProfileServiceImpl(UserProfileRepository userProfileRepository) {
		super();
		this.userProfileRepository = userProfileRepository;
	}


	@Override
	public UserProfile insertUserProfileInfo(UserProfile userProfile) throws Exception{
		
		logger.info("insertUserProfileInfo() Starts");
		
		com.learntech.teamtracker.manageprofile.entity.UserProfile userProfileEnty = new com.learntech.teamtracker.manageprofile.entity.UserProfile();
		
		userProfileEnty.setEmailId(userProfile.getEmailId());
		userProfileEnty.setFirstName(userProfile.getFirstName());
		userProfileEnty.setMiddleName(userProfile.getMiddleName());
		userProfileEnty.setLastName(userProfile.getLastName());
		userProfileEnty.setDob(DateConverterUtil.convertTimeStamp(userProfile.getDob()));
		userProfileEnty.setCreateDtTime(LocalDateTime.now());
		userProfileEnty.setUpdateDtTime(LocalDateTime.now());
		userProfileRepository.save(userProfileEnty);
		
		logger.info("insertUserProfileInfo() Ends");
		return userProfile;
	}


	@Override
	@Cacheable(value="users",key="#emailId")
	public UserProfile getUserProfileInfo(String emailId) throws Exception {
		
		logger.info("getUserProfileInfo() Starts");
		logger.info("Fetching UserProfile from DB Starts");
		Optional<com.learntech.teamtracker.manageprofile.entity.UserProfile> userProfileInfoOpt = userProfileRepository.findById(emailId);
		logger.info("Fetching UserProfile from DB Completed");
		
		UserProfile userProfModel = null;
		
		if(userProfileInfoOpt.isPresent()){
			com.learntech.teamtracker.manageprofile.entity.UserProfile userProfileInfo = userProfileInfoOpt.get();
			
			userProfModel = new UserProfile();
			
			userProfModel.setFirstName(userProfileInfo.getFirstName());
			userProfModel.setLastName(userProfileInfo.getLastName());
			userProfModel.setMiddleName(userProfileInfo.getMiddleName());
			userProfModel.setEmailId(userProfileInfo.getEmailId());
			userProfModel.setHostIp(InetAddress.getLocalHost().toString());
			userProfModel.setLastName(InetAddress.getLocalHost().getHostName());
		}
		logger.info("getUserProfileInfo() ends");
		return userProfModel;
	}
	
	
}
