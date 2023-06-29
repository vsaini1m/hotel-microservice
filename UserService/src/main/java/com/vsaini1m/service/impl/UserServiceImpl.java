package com.vsaini1m.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vsaini1m.entity.User;
import com.vsaini1m.exception.ResourceNotFoundException;
import com.vsaini1m.repositery.UserRepositery;
import com.vsaini1m.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepositery userRepositery;
	
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
		return this.userRepositery.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("User with given if not found !! : "+ userID));
	}

	@Override
	public void deleteUserById(String userID) {
		this.userRepositery.deleteById(userID);
	}

}
