package com.in28minutes.rest.webservices.restful_web_services.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/profile")
	public Profile filtering() {
		return new Profile("Navin", "Reddy", "Teleusko");
	}
	
	@GetMapping("/profiles")
	public List<Profile> filterProfiles() {
		List<Profile> profileList = new ArrayList<>();
		
		Profile profile1 = new Profile("Max", "Millan", "academind");
		Profile profile2 = new Profile("Andrew", "Z", "ZtoM");
		
		profileList.add(profile1);
		profileList.add(profile2);
		
		return profileList;
	}
}
