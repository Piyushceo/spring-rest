package com.piyush.springrest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory; 
@SpringBootApplication
public class SpringrestApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringrestApplication.class); 
	
	
	public static void displayCountries()
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
		LOGGER.debug("Countries : {}", countries);

	}
	
	public static void displayCountry()
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		Country country = context.getBean("country", Country.class);
		/**
		 * Demonstrating singleton & prototype scope
		 * remove scope from country.xml to demonstrate singleton
		 */
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country);
		LOGGER.debug("Country : {}",anotherCountry);
	}
	
	public static void displayDate() throws ParseException
	{
		LOGGER.info("START"); 
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml"); 
		 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		 String date = "31/12/2018";
		 LOGGER.debug(format.parse(date).toString());
		 LOGGER.debug(date); 
		 LOGGER.info("END");
	}
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringrestApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}

}
