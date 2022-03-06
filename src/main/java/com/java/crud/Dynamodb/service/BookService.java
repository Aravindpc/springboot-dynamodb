package com.java.crud.Dynamodb.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.crud.Dynamodb.entity.Book;
import com.java.crud.Dynamodb.repository.BookRepository;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public static final Logger Logger=LoggerFactory.getLogger(BookService.class);

	public Book createBook(Book book) {
		Book output=bookRepository.save(book);
		Logger.info("Created new Book");
        return output;
	}

    public Boolean deleteBook(String id) { 
		    bookRepository.deleteById(id);
    		Logger.info("Deleted Book with Id "+id);
			return true;
	}
    public Book updateBook(Book bookdto, String id)
    {
		Book output=null;

		Book book=bookRepository.findById(id).get();
    	BeanUtils.copyProperties(bookdto, book);
		output=bookRepository.save(book);
		Logger.info("Updated Book with id "+id);

		 return output;
    }

    public Iterable<Book> getAllBook()
    {   Iterable<Book> book=bookRepository.findAll();
    	Logger.info("Get all Book data");
		return book;
    }
    
    public Book getBook(String id)
    {
		Book book=bookRepository.findById(id).get();
		
		  return book;
    }

}
