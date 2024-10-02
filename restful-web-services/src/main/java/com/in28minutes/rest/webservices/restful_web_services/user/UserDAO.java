package com.in28minutes.rest.webservices.restful_web_services.user;

import java.util.List;

public interface UserDAO {
	public List<User> findAll();
	
	public User save(User user);
	
	public User findOne(int id);

	public void deleteById(int id);
}
