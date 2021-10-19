/**
 * 
 */
package com.example.postgresdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.model.Book;
import com.example.postgresdemo.service.BookService;

/**
 * @author Cybertech1
 *
 */
 @RestController
@RequestMapping("/book")
public class BookController {
	//book controller
	@Autowired
	private BookService bookService;

	@PostMapping("/save")
	public Book createProduct(final @Valid @RequestBody Book book) {
		return bookService.saveUpdate(book);
	}
}
