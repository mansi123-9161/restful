package com.mansi.webservice.restful.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mansi.webservice.restful.bean.SomeBean;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveBean() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		/*
		 * adding dynamic filtering: simpleBeanPropertyfilter is static which has
		 * various method which does filtering that we pass in FilterProvider interface
		 * which has one implementation SimpleFilterProvider and yes, filtering is
		 * working
		 */
		FilterProvider filters = new SimpleFilterProvider().addFilter("someVal",SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2"));
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}

}
