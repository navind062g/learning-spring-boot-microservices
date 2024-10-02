package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restful_web_services.jpa.UserRepository;

@Component
public class UserDaoService implements UserDAO {
	
	private UserRepository userRepository;
	
	
	@Autowired
	public UserDaoService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private static List<User> allUsers = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		allUsers.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		allUsers.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
		allUsers.add(new User(++usersCount,  "Jim", LocalDate.now().minusYears(20)));
	}

	@Override
	public List<User> findAll() {
		return allUsers;
	}

	@Override
	public User save(User user) {
		user.setId(++usersCount);
		allUsers.add(user);
		return user;
	}

	@Override
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return allUsers.stream().filter(predicate).findFirst().orElse(null);
	}

	@Override
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		allUsers.removeIf(predicate);		
	}

}
