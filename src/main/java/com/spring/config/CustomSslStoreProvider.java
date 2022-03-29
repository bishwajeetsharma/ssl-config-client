package com.spring.config;

import java.security.KeyStore;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.SslStoreProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.service.SpringCloudKeyStoreAdapter;

@Configuration
public class CustomSslStoreProvider implements SslStoreProvider {

	@Autowired
	private KeyStoreProperties keyStoreProperties;
	
	@Autowired
	private TrustStoreProperties trustStoreProperties;
	
	@Override
	@PostConstruct
	public KeyStore getKeyStore() throws Exception {
		System.out.println("returning keystore from customsslstoreprovider");
		return keyStoreProperties.getKeystore();
		
	}

	@Override
	@PostConstruct
	public KeyStore getTrustStore() throws Exception {
		System.out.println("returning truststore from customsslstoreprovider");
		return trustStoreProperties.getTruststore();
	}


}
