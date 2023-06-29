package com.vsaini1m.service;

import java.util.List;

import com.vsaini1m.entity.User;

public interface UserService {

	User saveUser(User user);
	
	User updateUser(User user);
	
	List<User> listOfAllUsers();
	
	User getUserById(String userID);
	
	void deleteUserById(String userID);
}
