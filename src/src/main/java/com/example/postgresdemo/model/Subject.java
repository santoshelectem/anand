/**
 * 
 */
package com.example.postgresdemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Cybertech1
 *
 */
@Entity
public class Subject {
	/**
	 * Subject subjectId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subjectId;

	/**
	 * Subject to Semester
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "semi_id", referencedColumnName = "semesterId")
	private Semester semester;

	/**
	 * Subject and Course
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "subject_cource", joinColumns = @JoinColumn(name = "subject_FK", referencedColumnName = "subjectId"), inverseJoinColumns = @JoinColumn(name = "cource_FK", referencedColumnName = "courceId"))
	private List<Course> subjectCouList = new ArrayList<Course>();
	
	/**
	 * Subject and Student
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "subject_student", joinColumns = @JoinColumn(name = "subject_FK", referencedColumnName = "subjectId"), inverseJoinColumns = @JoinColumn(name = "student_FK", referencedColumnName = "studentId"))
	private List<Student> subjectStudent = new ArrayList<>();
	
	

	/**
	 * @return the semester
	 */
	public Semester getSemester() {
		return semester;
	}

	/**
	 * @param semester
	 *            the semester to set
	 */
	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	/**
	 * @return the subjectCouList
	 */
	public List<Course> getSubjectCouList() {
		return subjectCouList;
	}

	/**
	 * @param subjectCouList
	 *            the subjectCouList to set
	 */
	public void setSubjectCouList(List<Course> subjectCouList) {
		this.subjectCouList = subjectCouList;
	}

	
	/**
	 * @return the subjectId
	 */
	public Integer getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * @return the subjectStudent
	 */
	public List<Student> getSubjectStudent() {
		return subjectStudent;
	}

	/**
	 * @param subjectStudent the subjectStudent to set
	 */
	public void setSubjectStudent(List<Student> subjectStudent) {
		this.subjectStudent = subjectStudent;
	}

	/**
	 * @param subjectId
	 * @param semester
	 * @param subjectCouList
	 */
	public Subject(Integer subjectId, Semester semester, List<Course> subjectCouList) {
		super();
		this.subjectId = subjectId;
		this.semester = semester;
		this.subjectCouList = subjectCouList;
	}

	/**
	 * 
	 */
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

}
