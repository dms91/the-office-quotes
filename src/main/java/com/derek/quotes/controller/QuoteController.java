package com.derek.quotes.controller;

import com.derek.quotes.entity.Quote;
import com.derek.quotes.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    // GETs
    @RequestMapping("/quotes")
    public List<Quote> getAllQuotes() {
        return quoteService.findAllQuotes();
    }

    @RequestMapping("/quotes/id/{id}")
    public Quote getQuoteById(@PathVariable @NotEmpty @NotNull long id) {
        return quoteService.findQuoteById(id);
    }

    @RequestMapping("/quotes/person/{person}")
    public List<Quote> getQuotesByPerson(@PathVariable @NotEmpty @NotNull String person) {
        return quoteService.findAllByPerson(person);
    }

    @RequestMapping("/quotes/random")
    public Quote getRandomQuote() {
        Random r = new Random();
        return quoteService.findAllQuotes().get(r.nextInt(quoteService.findAllQuotes().size()));
    }

    /*
    @RequestMapping(method=RequestMethod.POST, value="/quotes")
    public void postQuote(@RequestBody Quote q) {
        quoteService.saveQuote(q);
    }
*/
}
