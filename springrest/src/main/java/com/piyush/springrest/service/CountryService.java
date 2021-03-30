package com.piyush.springrest.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.piyush.springrest.Country;
import com.piyush.springrest.controller.HelloController;
import com.piyush.springrest.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	private static final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class); 

	private Country result; 
	public Country getCountry(String code) throws CountryNotFoundException
	{
		this.result = null;
		@SuppressWarnings("unchecked")
		ArrayList<Country> countryList= context.getBean("countryList",ArrayList.class);
		countryList.forEach(item->{
			LOGGER.debug("Result= {}",result);
			if(item.getCode().equalsIgnoreCase(code))
			{
				result = item;
				return;
			}
			
		});
		if(result==null)
		{
			LOGGER.debug("Throws exception");
			throw new CountryNotFoundException();
		}
		return result;
	}
}
