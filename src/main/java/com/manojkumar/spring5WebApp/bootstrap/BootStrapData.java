package com.manojkumar.spring5WebApp.bootstrap;

import com.manojkumar.spring5WebApp.domain.Author;
import com.manojkumar.spring5WebApp.domain.Book;
import com.manojkumar.spring5WebApp.repositories.AuthorRepository;
import com.manojkumar.spring5WebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by dev-manojkumar007 on 29 Apr, 2021
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author arthur = new Author("Arthur Conan","Doyle");
        Book baskerville = new Book("Hound of Baskerville","7623547");
        arthur.getBooks().add(baskerville);
        baskerville.getAuthors().add(arthur);

        authorRepository.save(arthur);
        bookRepository.save(baskerville);

        Author chetan = new Author("Chetan","Bhagat");
        Book states = new Book("2 States","7624347");
        arthur.getBooks().add(baskerville);
        baskerville.getAuthors().add(arthur);

        authorRepository.save(chetan);
        bookRepository.save(states);

        System.out.println("Bootstrap Started");
        System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Number of Authors : " + authorRepository.count());


    }
}
