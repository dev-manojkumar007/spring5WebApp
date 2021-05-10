package com.manojkumar.spring5WebApp.bootstrap;

import com.manojkumar.spring5WebApp.domain.Author;
import com.manojkumar.spring5WebApp.domain.Book;
import com.manojkumar.spring5WebApp.domain.Publisher;
import com.manojkumar.spring5WebApp.repositories.AuthorRepository;
import com.manojkumar.spring5WebApp.repositories.BookRepository;
import com.manojkumar.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by dev-manojkumar007 on 29 Apr, 2021
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrap Started");

        Publisher publisher = new Publisher();
        publisher.setName("Arihant Publications");
        publisher.setAddressLine1("Mayur Vihar Phase 3");
        publisher.setCity("Delhi");
        publisher.setCountry("India");
        publisher.setZipCode("110096");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count : " + publisherRepository.count());

        Author arthur = new Author("Arthur Conan","Doyle");
        Book baskerville = new Book("Hound of Baskerville","7623547");
        arthur.getBooks().add(baskerville);
        baskerville.getAuthors().add(arthur);

        baskerville.setPublisher(publisher);
        publisher.getBooks().add(baskerville);

        authorRepository.save(arthur);
        bookRepository.save(baskerville);
        publisherRepository.save(publisher);

        Author chetan = new Author("Chetan","Bhagat");
        Book states = new Book("2 States","7624347");
        chetan.getBooks().add(states);
        states.getAuthors().add(chetan);

        states.setPublisher(publisher);
        publisher.getBooks().add(states);

        authorRepository.save(chetan);
        bookRepository.save(states);
        publisherRepository.save(publisher);

        System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Number of Authors : " + authorRepository.count());
        System.out.println("Publisher Number of Books : " + publisher.getBooks().size());


    }
}
