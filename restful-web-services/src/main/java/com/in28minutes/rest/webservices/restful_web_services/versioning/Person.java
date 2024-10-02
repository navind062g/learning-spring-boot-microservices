package com.in28minutes.rest.webservices.restful_web_services.versioning;

public class Person {

	private String name;

	public Person(String theName) {
		this.name = theName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}
