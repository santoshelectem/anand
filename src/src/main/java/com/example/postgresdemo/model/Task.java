/**
 * 
 */
package com.example.postgresdemo.model;

import java.util.Date;

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
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	private String name;
	private String status;
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @param completedDate the completedDate to set
	 */
	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}
	private String colourResult;
	private String createdDate;
	private String completedDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="developerId")
	private Developer developer;
	
	
	/**
	 * @return the taskId
	 */
	public Integer getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
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
	 * @return the developer
	 */
	public Developer getDeveloper() {
		return developer;
	}
	/**
	 * @param developer the developer to set
	 */
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	/**
	 * @return the colourResult
	 */
	public String getColourResult() {
		return colourResult;
	}
	/**
	 * @param colourResult the colourResult to set
	 */
	public void setColourResult(String colourResult) {
		this.colourResult = colourResult;
	}
	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate.toString();
	}
	/**
	 * @return the completedDate
	 */
	public String getCompletedDate() {
		return completedDate;
	}
	/**
	 * @param completedDate the completedDate to set
	 */
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate.toString();
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 
	 */
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", name=" + name + ", status=" + status + ", colourResult=" + colourResult
				+ ", createdDate=" + createdDate + ", completedDate=" + completedDate + ", developer=" + developer
				+ "]";
	}
	
	
	

}
