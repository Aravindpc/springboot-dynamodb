package com.java.crud.Dynamodb.repository;

import com.java.crud.Dynamodb.entity.Book;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@EnableScan
@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
