package com.manojkumar.spring5WebApp.repositories;

import com.manojkumar.spring5WebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dev-manojkumar007 on 29 Apr, 2021
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
