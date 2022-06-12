package com.demo.raykov.webAppProject.repository;


import com.demo.raykov.webAppProject.model.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
