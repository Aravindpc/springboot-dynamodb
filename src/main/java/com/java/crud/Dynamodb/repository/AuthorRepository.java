package com.java.crud.Dynamodb.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.java.crud.Dynamodb.entity.Author;

import org.springframework.data.repository.CrudRepository;

@EnableScan
@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
}
