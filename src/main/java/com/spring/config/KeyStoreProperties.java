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



@ConfigurationProperties(prefix="keystore")
@Configuration
public class KeyStoreProperties {

	private String file;
	private String alias;
	private String provider;
	private String password;
	private String type;
	
	@PostConstruct
	public KeyStore getKeystore() {
		
		KeyStore keystore=null;
		System.out.println("keystore loading...");
		try{
			keystore=KeyStore.getInstance(type);
			byte[] byteout=Base64.getDecoder().decode(file);
			InputStream in = new ByteArrayInputStream(byteout);
			keystore.load(in, password.toCharArray());
			System.out.println("keystore load successful!");
		}catch(Exception ex) {
			System.out.println("couldn't load keystore successfully exception occured "+ex.getClass()+" "+ex.getLocalizedMessage());
		}
		return keystore;
	}
	public String getFile() {
		return this.file;
	}
	public void setFile(String file) {
		System.out.println("setter ran : keystore props : setFile");
		this.file = file;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
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
		return "KeyStoreProperties [file=" + file + ", alias=" + alias + ", provider=" + provider + ", password="
				+ password + ", type=" + type + "]";
	}
	public KeyStoreProperties() {
		toString();
	}
	
	
}
