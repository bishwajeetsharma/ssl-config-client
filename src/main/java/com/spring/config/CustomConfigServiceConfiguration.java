package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.SslStoreProvider;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.spring.resources.CustomPropertySourceLocator;

@Configuration
public class CustomConfigServiceConfiguration {

	@Bean
	public ConfigServicePropertySourceLocator configServicePropertySourceLocator(ConfigClientProperties clientProperties) {
		
		ConfigServicePropertySourceLocator configServicePropertySourceLocator = new CustomPropertySourceLocator(
				clientProperties);
		return configServicePropertySourceLocator;
	}
	
}
