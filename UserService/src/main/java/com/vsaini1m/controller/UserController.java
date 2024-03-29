package com.vsaini1m.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsaini1m.entity.User;
import com.vsaini1m.service.UserService;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		User saveUser = this.service.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(saveUser);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody User user){
		User saveUser = this.service.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(saveUser);
	}
	
	@GetMapping("/{userId}")
	// @CircuitBreaker(name = "ratingBreaker", fallbackMethod = "ratingBreaker")
	@Retry(name = "ratingService", fallbackMethod = "ratingBreaker")
	public ResponseEntity<?> getById(@PathVariable("userId") String userId){
		User user = this.service.getUserById(userId);
		
		return ResponseEntity.ok(user);
	}
	
	// @GetMapping("/{userId}")
	// @CircuitBreaker(name = "ratingBreaker", fallbackMethod = "ratingBreaker")
	public ResponseEntity<?> ratingBreaker(@PathVariable("userId") String userId, Exception exception) {
		log.info("Fallback is executed because service is down : " + exception.getMessage());
		User user = new User();
		user.setEmail("dummy@gmail.com");

		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteById(@PathVariable("userId") String userId){
		this.service.deleteUserById(userId);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<?> listOfAll(){
	List<User> listOfAllUsers = this.service.listOfAllUsers();
		return ResponseEntity.ok(listOfAllUsers);
	}
	 
}
