/**
 * 
 */
package com.learntech.teamtracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author UthirNew
 *
 */
@Entity
@Table(name="USER_REG_INFO",schema="ORACLETESTADMIN")
public class User {

	@Id
	@Column(name="EMAIL_ID",unique=true,length=50,nullable=false)
	private String emailId;
	
	@Column(name="USER_NAME",length=50,nullable=false)
	private String userName;
	
	@Column(name="PASSWORD",length=50,nullable=false)
	private String password;

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
