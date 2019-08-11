package com.derek.quotes.service;

import com.derek.quotes.dao.QuoteRepository;
import com.derek.quotes.entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public List<Quote> findAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote findQuoteById(long id) {
        Optional<Quote> temp = quoteRepository.findById(id);

        if (temp == null) {
            throw new RuntimeException("No quote with that id");
        }
        return temp.get();
    }

    @Override
    public List<Quote> findAllByPerson(String person) {
        if (person.length() < 1) {
            throw new RuntimeException("Person string is empty");
        }
        String personCapitalized = person.toLowerCase().substring(0, 1).toUpperCase() + person.substring(1);
        return quoteRepository.findByPerson(personCapitalized);
    }

    @Override
    public void saveQuote(Quote q) {
        quoteRepository.save(q);
    }

    @Override
    public void deleteQuote(Quote q) {
        quoteRepository.delete(q);
    }
}
