package com.spring.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Order(0)
public class CustomPropertySourceLocator extends ConfigServicePropertySourceLocator {

	
	private RestTemplate restTemplate;

	private ConfigClientProperties configClientProperties;

	public CustomPropertySourceLocator(ConfigClientProperties defaultProperties) {
		super(defaultProperties);
		this.configClientProperties = defaultProperties;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PropertySource<?> locate(Environment environment) {
		
		System.out.println("locate ran!!");
		org.springframework.cloud.config.environment.Environment resultEnv=null;
		ResponseEntity<org.springframework.cloud.config.environment.Environment>response=restTemplate.exchange("http://localhost:8888/configclient1/default", HttpMethod.GET, null,
		org.springframework.cloud.config.environment.Environment.class);
		this.configClientProperties.override(environment);
		CompositePropertySource composite= new CompositePropertySource("sslservice");
		if(response.hasBody()) {
			resultEnv=response.getBody();
			System.out.println(resultEnv.toString());
			resultEnv.getPropertySources().forEach(p -> composite.addPropertySource(new MapPropertySource("configServerssl", (Map<String, Object>) p.getSource())));
			this.configClientProperties.override(environment);
		}
		
		return composite;
		
	}

	@Override
	public void setRestTemplate(RestTemplate restTemplate) {
		// TODO Auto-generated method stub
		this.restTemplate=restTemplate;
	}

}
