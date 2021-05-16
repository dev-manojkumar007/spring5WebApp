package com.manojkumar.spring5WebApp.controllers;

import com.manojkumar.spring5WebApp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dev-manojkumar007 on 16 May, 2021
 */
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors",authorRepository.findAll());

        return "authors/list";

    }
}
