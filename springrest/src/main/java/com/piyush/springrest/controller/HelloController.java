package com.piyush.springrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.springrest.SpringrestApplication;

@RestController
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class); 

	@GetMapping("/hello")
	public String sayHello()
	{
		LOGGER.debug("hello method triggered");
		return "Hello World!";
	}
}
