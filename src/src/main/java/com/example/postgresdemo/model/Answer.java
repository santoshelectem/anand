package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer ansId;
	private String answername;
	private String postedBy;
	/**
	 * @return the ansId
	 */
	public Integer getAnsId() {
		return ansId;
	}
	
	public void setAnsId(Integer ansId) {
		this.ansId = ansId;
	}
	/**
	 * @return the answername
	 */
	public String getAnswername() {
		return answername;
	}
	/**
	 * @param answername the answername to set
	 */
	public void setAnswername(String answername) {
		this.answername = answername;
	}
	/**
	 * @return the postedBy
	 */
	public String getPostedBy() {
		return postedBy;
	}
	/**
	 * @param postedBy the postedBy to set
	 */
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	

}
