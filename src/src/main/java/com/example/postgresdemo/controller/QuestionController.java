/**
 * 
 */
package com.example.postgresdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Employee;
import com.example.postgresdemo.model.ProjectManager;
import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.service.QuestionService;

/**
 * @author Cybertech1
 *
 */
@RestController
@RequestMapping("/rest/api")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping("/Question")
	public Question saveQstAnsw(final @Valid @RequestBody Question question) {
		return questionService.saveQstAns(question);
	}

	@GetMapping("/question/answer/{qstId}")
	public Question getById(final @PathVariable(value = "qstId") Integer qstId) {
		Question fetchById = null;
		try {
			if (qstId != null) {
				fetchById = questionService.fetchById(qstId);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ResourceNotFoundException("id not match");
		}
		return fetchById;
	}
	@DeleteMapping("/delete/{qstId}")
	public void deletquestion(final @PathVariable(value = "qstId") Integer qstId) 
	{
		questionService.deleteQuest(qstId);
	}

}
