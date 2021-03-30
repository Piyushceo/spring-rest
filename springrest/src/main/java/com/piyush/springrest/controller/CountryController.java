package com.piyush.springrest.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.springrest.Country;
import com.piyush.springrest.service.CountryService;
import com.piyush.springrest.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	private static final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class); 

	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country")
	public Country getCountryIndia()
	{
		LOGGER.debug("Fetching country India JSON");
		return context.getBean("in",Country.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/countries")
	public ArrayList<Country> getAllCountries()
	{
		LOGGER.debug("Fetching country list");
		return context.getBean("countryList",ArrayList.class);
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException
	{
		return countryService.getCountry(code);
	}
}
