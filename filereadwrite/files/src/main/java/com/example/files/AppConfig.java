package com.example.files;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper();
    }
	
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
