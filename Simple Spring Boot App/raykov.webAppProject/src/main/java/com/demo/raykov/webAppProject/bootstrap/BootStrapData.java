package com.demo.raykov.webAppProject.bootstrap;

import com.demo.raykov.webAppProject.model.entity.Author;
import com.demo.raykov.webAppProject.model.entity.Book;
import com.demo.raykov.webAppProject.model.entity.Publisher;
import com.demo.raykov.webAppProject.repository.AuthorRepository;
import com.demo.raykov.webAppProject.repository.BookRepository;
import com.demo.raykov.webAppProject.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Author author = new Author("Niki", "Raykov");
        Book book = new Book("The mysteries of Spring", "The art of overwhelming");
        Publisher publisher = new Publisher("The Pragmatic Bookshelf", "9650 Strickland Rd Raleigh",
                "New York", "New York", 10001);

        author.getBooks().add(book);
        book.getAuthors().add(author);
        book.setPublisher(publisher);

        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publisher count: " + publisher.getBooks().size());

    }
}
