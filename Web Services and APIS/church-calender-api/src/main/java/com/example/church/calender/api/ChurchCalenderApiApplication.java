package com.example.church.calender.api;

import com.example.church.calender.api.entity.Calendar;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChurchCalenderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchCalenderApiApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(ChurchCalenderApiApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}
	//returns the calender information of today
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			Calendar calendar = restTemplate.getForObject("http://calapi.inadiutorium.cz/api/v0/en/calendars/default/today", Calendar.class);
			log.info(new Gson().toJson(calendar));//returning json
			System.out.println(new Gson().toJson(calendar));
		};
	}
}
