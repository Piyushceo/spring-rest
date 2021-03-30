package com.piyush.springrest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.piyush.springrest.controller.CountryController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringrestApplicationTests {

	@Autowired
	private CountryController countryController; 
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void contextLoads() {
		 assertNotNull(countryController);
	}
	
	 @Test
	 void testGetCountry() throws Exception {
		 ResultActions actions = mvc.perform(get("/country"));
		 actions.andExpect(status().isOk());
		 actions.andExpect(jsonPath("$.code").exists()); 
		 actions.andExpect(jsonPath("$.code").value("IN"));
	 } 
	 
	 @Test
	 void testGetCountryException() throws Exception {
		 ResultActions actions = mvc.perform(get("/countries/oz"));
		 actions.andExpect(status().isNotFound());
		 actions.andExpect(status().reason("Country not found")); 
	 }
}
