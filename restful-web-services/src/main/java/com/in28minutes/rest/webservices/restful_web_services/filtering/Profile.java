package com.in28minutes.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Profile {
	
	private String firstName;
	
	private String lastName;
	
	@JsonIgnore
	private String youTubeChannelID;	

	public Profile(String firstName, String lastName, String youTubeChannelID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.youTubeChannelID = youTubeChannelID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getYouTubeChannelID() {
		return youTubeChannelID;
	}

	public void setYouTubeChannelID(String youTubeChannelID) {
		this.youTubeChannelID = youTubeChannelID;
	}

	@Override
	public String toString() {
		return "Profile [firstName=" + firstName + ", lastName=" + lastName + ", youTubeChannelID=" + youTubeChannelID
				+ "]";
	}
	
	

}
