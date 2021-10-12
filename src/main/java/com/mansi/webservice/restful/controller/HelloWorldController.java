package com.mansi.webservice.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mansi.webservice.restful.bean.HelloWorldBean;

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

	@GetMapping(path ="/helloWorld-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World from bean");
	}

	@GetMapping(path ="/helloWorld-bean/path/{name}")
	public HelloWorldBean helloWorldPthVarible(@PathVariable String name) {
		return new HelloWorldBean("Hello World from pathvar %s"+ name);
	}
}
