package com.in28minutes.rest.webservices.restful_web_services.user;

import java.util.List;

public interface PostService {
	public List<Post> findAll();
	
	public Post save(Post post);
	
	public Post findOne(int id);

	public void deleteById(int id);
}
