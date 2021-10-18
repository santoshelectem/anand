/**
 * 
 */
package com.example.postgresdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Course;
import com.example.postgresdemo.model.Semester;
import com.example.postgresdemo.model.Subject;
import com.example.postgresdemo.repository.SemesterRepository;

/**
 * @author Cybertech1
 *
 */
@RestController
@RequestMapping("/student/semester")
public class SemesterController {
	
	protected final static Logger log = LoggerFactory.getLogger(SemesterController.class);
	/**
	 * semesterRepository
	 */
	@Autowired
	private SemesterRepository semesterRepository;
	
	/**
	 * @param semester
	 * @return
	 */
	@PostMapping("/Save")
	public Semester saveSemester(final @Valid @RequestBody Semester semester) {
		log.info("start SemesterController : saveSemester ");
		try {
			if (semester != null) {
				return semesterRepository.save(semester);
			}
		} catch (Exception e) {
			// TODO: handle exception.
			log.error("SemesterController: saveSemester" + e.getMessage());

		}
		log.info("End SemesterController : saveSemester ");
		return semester;

	}
	
	/**
	 * @return
	 */
	@GetMapping("/get/all")
	public List<Semester> fetch() {
		List<Semester> semester;
		try {
			semester = semesterRepository.findAll();

		} catch (ResourceNotFoundException e) {
			log.error("SemesterController: fetch" + e.getMessage());
			throw new ResourceNotFoundException("error");
		}
		return semester;
	}

}
