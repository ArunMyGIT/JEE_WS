package com.my.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import java.util.Arrays;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.my.samples.model.Quote;

@SpringBootApplication
public class RESTConsumerApplication {
	private static final Logger log = LoggerFactory.getLogger(RESTConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RESTConsumerApplication.class, args);
	}
	
	
	/* This method is used to PRINT all the bean names that are loaded for This Spring BOOT Application	*/
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}


}
