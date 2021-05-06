package com.manojkumar.spring5WebApp.repositories;

import com.manojkumar.spring5WebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dev-manojkumar007 on 06 May, 2021
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
