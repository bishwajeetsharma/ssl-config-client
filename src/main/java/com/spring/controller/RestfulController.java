package com.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

	@Value("${name}")
	private String name;
	
	@Value("${greeting}")
	private String greeting;
	@GetMapping("/hello")
	public String hello() {
		
		return String.format("name:{%s}\ngreeting:{%s}", name,greeting);
		
	}
}
