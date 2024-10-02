package com.in28minutes.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public Person getFirstVersionOfPerson() {
		return new Person("Navin Reddy");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2("Bob", "Charlie");
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public Person getFirstVersionOfPersonRequestParameter() {
		return new Person("Navin Reddy");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2("Bob", "Charlie");
	}
}
