/**
 * 
 */
package com.example.postgresdemo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * @author Cybertech1
 *
 */
@Entity
public class Developer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer developerId;
	private String emailId;
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="statusId")
	private Status status;
	/**
	 * @return the developerId
	 */
	public Integer getDeveloperId() {
		return developerId;
	}
	/**
	 * @param developerId the developerId to set
	 */
	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}
