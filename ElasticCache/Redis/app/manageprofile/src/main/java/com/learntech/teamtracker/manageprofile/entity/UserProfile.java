/**
 * 
 */
package com.learntech.teamtracker.manageprofile.entity;

/*import java.sql.Date;*/
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/

/**
 * @author UthirNew
 *
 */
@Entity
@Table(name="USER_PROFILE",schema="UTHIRCLOUDADMIN")
public class UserProfile {

	@Id
	@Column(name="EMAIL_ID",unique=true,length=50,nullable=false)
	private String emailId;
	
	@Column(name="FIRST_NM",length=100,nullable=false)
	private String firstName;
	
	@Column(name="LAST_NM",length=100,nullable=false)
	private String lastName;
	
	@Column(name="MIDDLE_NM",length=100,nullable=true)
	private String middleName;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="DOB",length=25,nullable=false)
	private LocalDate dob;
	
	@Column(name="CREATE_DATE_TIME",length=25,nullable=false)
	private LocalDateTime createDtTime;
	
	@Column(name="UPDATE_DATE_TIME",length=25,nullable=false)
	private LocalDateTime updateDtTime;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * @return the createDtTime
	 */
	public LocalDateTime getCreateDtTime() {
		return createDtTime;
	}

	/**
	 * @param createDtTime the createDtTime to set
	 */
	public void setCreateDtTime(LocalDateTime createDtTime) {
		this.createDtTime = createDtTime;
	}

	/**
	 * @return the updateDtTime
	 */
	public LocalDateTime getUpdateDtTime() {
		return updateDtTime;
	}

	/**
	 * @param updateDtTime the updateDtTime to set
	 */
	public void setUpdateDtTime(LocalDateTime updateDtTime) {
		this.updateDtTime = updateDtTime;
	}
	
	
}
