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

import com.java.crud.Dynamodb.entity.Author;
import com.java.crud.Dynamodb.service.AuthorService;


@Controller
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	public static final Logger Logger=LoggerFactory.getLogger(AuthorController.class);

	@GetMapping("/getAuthor")
	public ResponseEntity<Iterable<Author>> getAuthor(HttpServletRequest request) {
		Iterable<Author> output = authorService.getAllAuthor();
		Logger.info("Retrived all Authors ");
		return ResponseEntity.ok(output);
	}
	@GetMapping("/getOneAuthor")
	public ResponseEntity<Author> getOneAuthor(@RequestParam(value = "id") String id) {
		Author output = authorService.getAuthor(id);
		return ResponseEntity.ok(output);
	}
	
	@PostMapping(value = "/createAuthor")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
		Author output =authorService.createAuthor(author);
		Logger.info("Author created");
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateAuthor")
	public ResponseEntity<Author> updateAuthor(@RequestParam(value="id")String id,@RequestBody Author author) {
		Author output =authorService.updateAuthor(author,id);
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	@DeleteMapping(value = "/deleteAuthor")
	public ResponseEntity<Boolean> deleteAuthor(@RequestParam(value = "id") String id) {
		Boolean output =authorService.deleteAuthor(id);
	
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
}
