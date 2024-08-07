package com.example.Book.BookResttemp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BookRestTemplateConfig {

	
	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
}
