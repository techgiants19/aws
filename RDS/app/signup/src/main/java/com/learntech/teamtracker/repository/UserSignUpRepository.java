/**
 * 
 */
package com.learntech.teamtracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learntech.teamtracker.entity.User;

/**
 * @author UthirNew
 *
 */
@Repository
public interface UserSignUpRepository extends CrudRepository<User,String> {

}
