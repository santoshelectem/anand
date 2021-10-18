/**
 * 
 */
package com.example.postgresdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Cybertech1
 *
 */
@Entity
public class Status {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer statusId;
	private Integer currentlyDoingCount;
	private	Integer completedCount;
	private Integer toDoCount;
	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	/**
	 * @return the currentlyDoingCount
	 */
	public Integer getCurrentlyDoingCount() {
		return currentlyDoingCount;
	}
	/**
	 * @param currentlyDoingCount the currentlyDoingCount to set
	 */
	public void setCurrentlyDoingCount(Integer currentlyDoingCount) {
		this.currentlyDoingCount = currentlyDoingCount;
	}
	/**
	 * @return the completedCount
	 */
	public Integer getCompletedCount() {
		return completedCount;
	}
	/**
	 * @param completedCount the completedCount to set
	 */
	public void setCompletedCount(Integer completedCount) {
		this.completedCount = completedCount;
	}
	/**
	 * @return the toDoCount
	 */
	public Integer getToDoCount() {
		return toDoCount;
	}
	/**
	 * @param toDoCount the toDoCount to set
	 */
	public void setToDoCount(Integer toDoCount) {
		this.toDoCount = toDoCount;
	}

}
