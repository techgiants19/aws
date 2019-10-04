/**
 * 
 */
package com.learntech.teamtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author UthirNew
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(value=Include.NON_NULL)
public class User {
	@JsonInclude(value=Include.NON_EMPTY)
	private String emailId;
	@JsonInclude(value=Include.NON_EMPTY)
	private String userName;
	@JsonInclude(value=Include.NON_EMPTY)
	private String password;
	@JsonInclude(value=Include.NON_EMPTY)
	private String lastLogInTime;
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
	
	
	/**
	 * @return the lastLogInTime
	 */
	public String getLastLogInTime() {
		return lastLogInTime;
	}
	/**
	 * @param lastLogInTime the lastLogInTime to set
	 */
	public void setLastLogInTime(String lastLogInTime) {
		this.lastLogInTime = lastLogInTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((lastLogInTime == null) ? 0 : lastLogInTime.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (lastLogInTime == null) {
			if (other.lastLogInTime != null)
				return false;
		} else if (!lastLogInTime.equals(other.lastLogInTime))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", userName=" + userName + ", password=" + password + ", lastLogInTime="
				+ lastLogInTime + "]";
	}
	
	

}
