package com.example.consuming.soap;

import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class ConsumingSoapApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingSoapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		NumberClient numberClient = new NumberClient();

		//create and setup marshaller
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		//provide location to the ObjectFactory
		marshaller.setContextPath("com.dataaccess.webservicesserver");

		numberClient.setMarshaller(marshaller);

		numberClient.setUnmarshaller(marshaller);

		NumberToWordsResponse response = numberClient.getWords("3454");
		System.out.println("The response is: " + response.getNumberToWordsResult());
	}
}
