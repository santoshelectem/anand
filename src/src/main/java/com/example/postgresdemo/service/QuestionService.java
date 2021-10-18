/**
 * 
 */
package com.example.postgresdemo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.QuestionRepository;

/**
 * @author Cybertech1
 *
 */
@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question saveQstAns(@Valid Question question) {
		// TODO Auto-generated method stub
		return questionRepository.save(question);
	}

	public Question fetchById(Integer qstId) {
		return questionRepository.findById(qstId).orElseThrow(() -> new ResourceNotFoundException("Question"));
		// TODO Auto-generated method stub

	}
	
    public void deleteQuest(final @PathVariable Integer qstId){
		questionRepository.deleteById(qstId);

    }

}
