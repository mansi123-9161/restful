package com.mansi.webservice.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansi.webservice.restful.bean.SomeBean;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveBean() {
		return new SomeBean("value1","value2","value3");
	}

}
