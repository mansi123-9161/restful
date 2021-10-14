package com.mansi.webservice.restful.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping("v1/person")
	public PersonV1 personv1() {
		return new PersonV1("hello charlie");
	}
	@GetMapping("v2/person")
	public PersonV2 personv2() {
		return new PersonV2(new Name("hello", "martie"));
	}
}
