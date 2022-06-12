package com.demo.raykov.webAppProject.repository;

import com.demo.raykov.webAppProject.model.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
