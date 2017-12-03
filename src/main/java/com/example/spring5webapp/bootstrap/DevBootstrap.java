package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.model.Publisher;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DevBootstrap.class);

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    // Constructor AutoInjection to AutoWire the Repositories


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        LOGGER.info("InitData Called : DevBootstarp Class");
        initData();
    }

    private void initData(){

        Publisher apress = new Publisher();
        apress.setName("Apress Inc");
        publisherRepository.save(apress);
        LOGGER.info("Apress Publisher Created");

        Publisher wrox = new Publisher();
        wrox.setName("Wrox Inc");
        publisherRepository.save(wrox);
        LOGGER.info("Wrox Publisher Created");

        // Adding John
        LOGGER.info("Adding John");
        Author john = new Author("John", "Doe");
        Book ddd = new Book("Domain Driven Design", "1234", apress);
        john.getBooks().add(ddd);
        ddd.getAuthors().add(john);
        authorRepository.save(john);
        bookRepository.save(ddd);
        LOGGER.info("Added John");

        // Adding Rod
        LOGGER.info("Adding Rod");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2244", wrox);
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        LOGGER.info("Added Rod");





    }
}
