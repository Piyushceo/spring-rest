package com.piyush.springrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private String code;
	private String name;
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class); 

	public String getCode() {
		LOGGER.debug("Inside getCode()");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Setting country code");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside getName()");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Setting country name");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", country=" + name + "]";
	}
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
		LOGGER.debug("Inside Country Constructor");
	}
	public Country() {
		super();
		LOGGER.debug("Inside Country Constructor");

	}
	
}
