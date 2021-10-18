/**
 * 
 */
package com.example.postgresdemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Course;
import com.example.postgresdemo.model.Employee;
import com.example.postgresdemo.model.Student;
import com.example.postgresdemo.repository.CourseRepository;

/**
 * @author Cybertech1
 *
 */
@RestController
@RequestMapping("student/course")
public class CourseController {
	/**
	 * Logger
	 */
	Logger log = LoggerFactory.getLogger(CourseController.class);

	/**
	 * courseRepository
	 */
	@Autowired
	private CourseRepository courseRepository;

	/**
	 * @param course
	 * @return
	 */
	@PostMapping("/Save")
	public Course saveCourse(final @Valid @RequestBody Course course) {
		try {
			if (course != null) {
				return courseRepository.save(course);
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error("CourseController: saveCourse" + e.getMessage());

		}
		return course;
	}

	/**
	 * @return
	 */
	@GetMapping("/get/all")
	public List<Course> fetchCourse() {
		final List<Course> course;
		try {
			course = courseRepository.findAll();
		} catch (ResourceNotFoundException e) {
			log.error("CourseController: fetchCourse" + e.getMessage());
			throw new ResourceNotFoundException("error");
		}
		return course;
	}

	/**
	 * @param courseId
	 * @return
	 */
	@GetMapping("/course/{courseId}")
	public Optional<Course> fetchCourseId(final @PathVariable Integer courseId) {
		Optional<Course> course = null;

		try {
			if (courseId != null) {
				course = courseRepository.findById(courseId);
			}

		} catch (ResourceNotFoundException e) {
			log.error("CourseController: fetchCourseId" + e.getMessage());
			throw new ResourceNotFoundException("se");
		}
		return course;
	}

	/**
	 * @param courseId
	 * @param courseUpdate
	 * @return updating the course
	 */
	@PutMapping("/course/{courseId}")
	public ResponseEntity<Course> updatecource(final @PathVariable Integer courseId,
			final @RequestBody Course courseUpdate) {
		final Course courseUpdat = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id: " + courseId));

		courseUpdat.setStuCourceList(courseUpdate.getStuCourceList());
		courseUpdat.setSubjectList(courseUpdate.getSubjectList());
		courseRepository.save(courseUpdat);
		return ResponseEntity.ok(courseUpdat);
	}

}
