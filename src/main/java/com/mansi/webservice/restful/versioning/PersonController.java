package com.mansi.webservice.restful.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping(value = "person/param",params = "v1")
	public PersonV1 personv1() {
		return new PersonV1("hello charlie");
	}
	@GetMapping(value = "person/param",params = "v2")
	public PersonV2 personv2() {
		/* localhost:8080/person/param?v2 */
		return new PersonV2(new Name("hello", "martie"));
	}
}
