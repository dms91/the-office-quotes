package com.derek.quotes.scheduler;

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

    @Scheduled(fixedRate = 10000)
    public void reportSuggestions() throws FileNotFoundException {
        String filename = "/src/main/java/com/derek/quotes/scheduler/suggestions.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                log.info("current line is: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
