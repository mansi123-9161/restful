package com.mansi.webservice.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	/*
	 * @GetMapping is a composed annotation that acts as a shortcut
	 * for @RequestMapping(method = RequestMethod.GET).
	 * @GetMapping is the newer annotaion. It supports consumes
	 * GetMapping we can apply only on method level and RequestMapping annotation we
	 * can apply on class level and as well as on method level
	 */
	@GetMapping(path ="/helloWorld")
	public String helloWorld() {
		return "hello there";
	}

}
