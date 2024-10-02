package com.in28minutes.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restful_web_services.jpa.PostRepository;

import jakarta.transaction.Transactional;

@Component
public class PostServiceImpl implements PostService {
	
	private PostRepository postRepository;
	
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	@Transactional
	public Post save(Post post) {
		return this.postRepository.save(post);
	}

	@Override
	public Post findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

}
