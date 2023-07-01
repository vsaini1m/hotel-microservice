package com.vsaini1m.rating.controller;

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

import com.vsaini1m.rating.entity.Rating;
import com.vsaini1m.rating.service.RatingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {
	
	private final RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingService.create(rating));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Rating rating){
		return ResponseEntity.ok(this.ratingService.update(rating));
	}
	
	@GetMapping
	public ResponseEntity<?> all() {
		return ResponseEntity.ok(this.ratingService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id){
		return ResponseEntity.ok(this.ratingService.getById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id){
		this.ratingService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/hotel/{id}")
	public ResponseEntity<?> allByHotelId(@PathVariable("id") String id) {
		return ResponseEntity.ok(this.ratingService.getAllByHotelId(id));
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> allByUserId(@PathVariable("id") String id) {
		return ResponseEntity.ok(this.ratingService.getAllByUserId(id));
	}
}
