package com.spring.service;

import java.security.KeyStore;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.config.KeyStoreProperties;
import com.spring.config.TrustStoreProperties;

@Component
public class SpringCloudKeyStoreAdapter implements KeyStoreAdapter {

	@Autowired
	private KeyStoreProperties keyStoreProperties;
	
	@Autowired
	private TrustStoreProperties trustStoreProperties;
	
	@Override
	@PostConstruct
	public KeyStore getKeyStore() {
		System.out.println("returning keystore from SpringCloudKeyStoreAdapter");
		return keyStoreProperties.getKeystore();
	}

	@Override
	@PostConstruct
	public KeyStore getTrustStore() {
		System.out.println("returning truststore from SpringCloudKeyStoreAdapter");
		return trustStoreProperties.getTruststore();
	}
	

	@Override
	public String toString() {
		return "SpringCloudKeyStoreAdapter [keyStoreProperties=" + keyStoreProperties + ", trustStoreProperties="
				+ trustStoreProperties + ", getKeyStore()=" + getKeyStore() + ", getTrustStore()=" + getTrustStore()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	

}
