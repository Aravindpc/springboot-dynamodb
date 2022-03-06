package com.java.crud.Dynamodb.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.crud.Dynamodb.entity.Author;
import com.java.crud.Dynamodb.repository.AuthorRepository;


@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public static final Logger Logger=LoggerFactory.getLogger(AuthorService.class);

	public Author createAuthor(Author author) {
		Author output=authorRepository.save(author);
		Logger.info("Created new Author");
        return output;
	}

    public Boolean deleteAuthor(String id) {
		    authorRepository.deleteById(id);
    		Logger.info("Deleted Author with Id "+id);
			return true;
	}
    public Author updateAuthor(Author authordto, String id)
    {   Author output=null;
		Author author=authorRepository.findById(id).get();
    	BeanUtils.copyProperties(authordto, author);
		output=authorRepository.save(author);
		 return output;
    }

    public Iterable<Author> getAllAuthor()
    {   Iterable<Author> author=authorRepository.findAll();
    	Logger.info("Get all Author data");
		return author;
    }
    
    public Author getAuthor(String id)
    {
		Author author=authorRepository.findById(id).get();
		  return author;
    }

}
