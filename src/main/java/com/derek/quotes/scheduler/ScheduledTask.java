package com.derek.quotes.scheduler;

import com.derek.quotes.entity.Quote;
import com.derek.quotes.service.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;


@Component
public class ScheduledTask {

    @Autowired
    private QuoteService quoteService;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private File file = new File("src/main/resources/suggestions.txt");
    private FileWriter fw;

    @Scheduled(fixedRate = 10000)
    public void reportSuggestions() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";

        while ((line = br.readLine()) != null) {
            Quote q = new Quote();

            String[] words = line.split(":");
            q.setPerson(words[0].trim());
            q.setQuote(words[1].trim());

            quoteService.saveQuote(q);
            log.info("****** saved quote ******");
        }
        br.close();
        fw = new FileWriter(file, false);
        fw.close();
    }
}
