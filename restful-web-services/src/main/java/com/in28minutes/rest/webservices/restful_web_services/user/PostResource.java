package com.in28minutes.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class PostResource {
	
	private PostService postService;
	
	private UserDAO userDAO;
	
	public PostResource(PostService postService, @Qualifier("userJpaDaoService") UserDAO userDAO) {
		this.postService = postService;
		this.userDAO = userDAO;
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		User userFound = userDAO.findOne(id);
		
		if(userFound == null) {
			throw new UserNotFoundException("id " + id);
		}
		
		return userFound.getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		User userFound = userDAO.findOne(id);
		
		if(userFound == null) {
			throw new UserNotFoundException("id " + id);
		}
		
		userFound.addPost(post);
		post.setUser(userFound);
		
		Post savedPost =  postService.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
