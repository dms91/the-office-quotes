package com.derek.quotes.dao;

import com.derek.quotes.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(path="quotes")
@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findByPerson(String person);
}
