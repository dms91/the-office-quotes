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
    private File filename = new File("src/main/resources/suggestions.txt");

    @Scheduled(fixedRate = 10000)
    public void reportSuggestions() throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(":");
                System.out.println("[0]: " + arr[0]);
                System.out.println("[1]: " + arr[1]);

                line.trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
