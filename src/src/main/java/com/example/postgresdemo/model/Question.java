package com.example.postgresdemo.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qstId;
	private String qname;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "qid")
	private List<Answer> answers;

	/**
	 * @return the qstId
	 */
	public Integer getQstId() {
		return qstId;
	}

	/**
	 * @param qstId the qstId to set
	 */
	public void setQstId(Integer qstId) {
		this.qstId = qstId;
	}

	/**
	 * @return the qname
	 */
	public String getQname() {
		return qname;
	}

	/**
	 * @param qname the qname to set
	 */
	public void setQname(String qname) {
		this.qname = qname;
	}

	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	

}
