/**
 * 
 */
package com.example.postgresdemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Cybertech1
 *
 */
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	@Column(name = "book_name")
	private String bookName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_Id", referencedColumnName = "bookId")
	private List<Story> storyList = new ArrayList<>();
    
	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<Story> getStoryList() {
		return storyList;
	}

	public void setStoryList(List<Story> storyList) {
		this.storyList = storyList;
	}

}
