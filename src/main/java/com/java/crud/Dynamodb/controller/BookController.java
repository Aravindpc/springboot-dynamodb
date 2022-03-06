package com.java.crud.Dynamodb.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.crud.Dynamodb.entity.Book;
import com.java.crud.Dynamodb.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	public static final Logger Logger=LoggerFactory.getLogger(BookController.class);

	@GetMapping("/getBook")
	public ResponseEntity<Iterable<Book>> getBook(HttpServletRequest request) {
		Iterable<Book> output = bookService.getAllBook();
		Logger.info("Retrived all Books ");
		return ResponseEntity.ok(output);
	}
	@GetMapping("/getOneBook")
	public ResponseEntity<Book> getOneBook(@RequestParam(value = "id") String id) {
		Book output = bookService.getBook(id);
		 
		return ResponseEntity.ok(output);
	}
	
	@PostMapping(value = "/createBook")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book output =bookService.createBook(book);
		Logger.info("Book created");
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateBook")
	public ResponseEntity<Book> updateBook(@RequestParam(value="id")String id,@RequestBody Book book) {
		Book output =bookService.updateBook(book,id);
		 
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	@DeleteMapping(value = "/deleteBook")
	public ResponseEntity<Boolean> deleteBook(@RequestParam(value = "id") String id) {
		Boolean output =bookService.deleteBook(id);
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
}
