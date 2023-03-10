package com.example.consumingrestful;

import com.example.consumingrestful.model.Quote;
import com.example.consumingrestful.resource.QuoteResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
public class ConsumingRestfulApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestfulApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			QuoteResource quoteResource = restTemplate.getForObject(
				"http://localhost:7898/api/random", QuoteResource.class);
			log.info(quoteResource.toString());
		};
	}
}
