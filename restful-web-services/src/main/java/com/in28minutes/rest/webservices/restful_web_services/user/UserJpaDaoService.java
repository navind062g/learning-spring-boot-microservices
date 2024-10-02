package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class UserJpaDaoService implements UserDAO {
	
	private UserRepository userRepository;
	
	
	@Autowired
	public UserJpaDaoService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	@Transactional
	public User save(User user) {
		this.userRepository.save(user);
		return user;
	}

	@Override
	public User findOne(int id) {
		Optional<User> userFound = this.userRepository.findById(id);
		return userFound.get();
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		this.userRepository.deleteById(id);		
	}

}
