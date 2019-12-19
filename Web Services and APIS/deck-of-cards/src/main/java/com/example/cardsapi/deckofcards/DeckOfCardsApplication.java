package com.example.cardsapi.deckofcards;

import com.example.cardsapi.deckofcards.entity.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class DeckOfCardsApplication {
    private static final Logger log = LoggerFactory.getLogger(DeckOfCardsApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DeckOfCardsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    //to draw a card
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
        return args -> {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<Response> response = restTemplate.exchange("https://deckofcardsapi.com/api/deck/new/draw/?count=2", HttpMethod.GET, entity, Response.class);
            System.out.println(response.getBody().toString());
        };
    }
}
