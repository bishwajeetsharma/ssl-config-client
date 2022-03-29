package com.spring.config;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Base64;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@ConfigurationProperties(prefix="truststore")
@Configuration
public class TrustStoreProperties {

	private String file;
	private String provider;
	private String password;
	private String type;

	@PostConstruct
	public KeyStore getTruststore() {

		KeyStore keystore = null;
		try {
			keystore = KeyStore.getInstance(type);
			byte[] byteout=Base64.getDecoder().decode(file);
			InputStream in = new ByteArrayInputStream(byteout);
			keystore.load(in, password.toCharArray());
			System.out.println("keystore load successful!");
		} catch (Exception ex) {
			System.out.println("couldn't load keystore successfully exception occured " + ex.getClass() + " "
					+ ex.getLocalizedMessage());
		}
		return keystore;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TrustStoreProperties [file=" + file + ", provider=" + provider + ", password=" + password + ", type="
				+ type + "]";
	}

	public TrustStoreProperties() {
		toString();
	}
	

}
