/**
 * 
 */
package com.learntech.teamtracker.manageprofile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learntech.teamtracker.manageprofile.entity.UserProfile;


/**
 * @author UthirNew
 *
 */
@Repository
public interface UserProfileRepository  extends CrudRepository<UserProfile,String>{

}
