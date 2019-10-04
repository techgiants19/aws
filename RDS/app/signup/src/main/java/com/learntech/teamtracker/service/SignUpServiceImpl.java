/**
 * 
 */
package com.learntech.teamtracker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.learntech.teamtracker.model.User;
import com.learntech.teamtracker.repository.UserSignUpRepository;

/**
 * @author UthirNew
 *
 */
@Service
public class SignUpServiceImpl implements SignUpService {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpServiceImpl.class);
	
	private UserSignUpRepository userSignUpRepository;
	
	public SignUpServiceImpl(UserSignUpRepository userSignUpRepository) {
		this.userSignUpRepository = userSignUpRepository;
	}

	@Override
	public User userSignUp(User user) {
		
		logger.info("userSignUp(User user) Starts");
		com.learntech.teamtracker.entity.User userEnty = new com.learntech.teamtracker.entity.User();
		
		userEnty.setEmailId(user.getEmailId());
		userEnty.setUserName(user.getUserName());
		userEnty.setPassword(user.getPassword());
		
		userSignUpRepository.save(userEnty);
		
		logger.info("userSignUp(User user) Ends");
		return user;
	}
	
}
