package com.derek.quotes.service;

import com.derek.quotes.entity.Quote;

import java.util.List;

public interface QuoteService {

    // GETs
    public List<Quote> findAllQuotes();
    public Quote findQuoteById(long id);
    public List<Quote> findAllByPerson(String person);

    // POSTs
    public void saveQuote(Quote q);
    public void deleteQuote(Quote q);
}
