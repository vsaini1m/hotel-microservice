package com.vsaini1m.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vsaini1m.entity.Rating;
import com.vsaini1m.entity.User;
import com.vsaini1m.exception.ResourceNotFoundException;
import com.vsaini1m.repositery.UserRepositery;
import com.vsaini1m.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

	private final UserRepositery userRepositery;
	private final RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) {
		return this.userRepositery.save(user);
	}

	@Override
	public User updateUser(User user) {
		return this.userRepositery.save(user);
	}

	@Override
	public List<User> listOfAllUsers() {
		return this.userRepositery.findAll();
	}

	@Override
	public User getUserById(String userID) {
		User user = this.userRepositery.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("User with given if not found !! : "+ userID));
		String url = "http://127.0.0.1:8091/ratings/user/" + user.getId();
		ArrayList<Rating> ratings = this.restTemplate.getForObject(url, ArrayList.class);
		log.info("{}", ratings);
		user.setRatings(ratings);

		return user;
	}

	@Override
	public void deleteUserById(String userID) {
		this.userRepositery.deleteById(userID);
	}

}
