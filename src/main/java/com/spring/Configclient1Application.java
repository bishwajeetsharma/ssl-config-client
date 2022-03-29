package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import com.spring.config.KeyStoreProperties;
import com.spring.config.TrustStoreProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Configclient1Application {

	public static void main(String[] args) {
		SpringApplication.run(Configclient1Application.class, args);
		
	}
	
}
