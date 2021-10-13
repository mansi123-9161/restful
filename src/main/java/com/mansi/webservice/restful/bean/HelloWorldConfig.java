package com.mansi.webservice.restful.bean;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class HelloWorldConfig {
	
	/*
	 * we cant directly call autowire in controller, it will give null message
	 * resource, instead we need to create a config class and define bean of
	 * messageresource and set the base name, it should be folder name followed by
	 * your file name initials
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource res = new ResourceBundleMessageSource();
		res.setBasename("messages/messages");
		return res;
	}

}
