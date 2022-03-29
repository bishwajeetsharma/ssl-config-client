package com.spring.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomWebServer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	@Autowired
	private CustomSslStoreProvider customSslStoreProvider;
	
	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		// TODO Auto-generated method stub
		Ssl ssl=new Ssl();
		ssl.setEnabled(true);
		ssl.setKeyAlias("enduser");
		ssl.setKeyPassword("endUser");
		factory.setSsl(ssl);
		factory.setSslStoreProvider(this.customSslStoreProvider);
		
	}


	
	
}
