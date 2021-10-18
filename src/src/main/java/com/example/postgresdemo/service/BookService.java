/**
 * 
 */
package com.example.postgresdemo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.model.Book;
import com.example.postgresdemo.repository.BookRepository;

/**
 * @author Cybertech1
 *
 */
@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public Book saveUpdate(@Valid Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

}
