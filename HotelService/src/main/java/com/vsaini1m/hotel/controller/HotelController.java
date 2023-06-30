package com.vsaini1m.hotel.controller;

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

import com.vsaini1m.hotel.entity.Hotel;
import com.vsaini1m.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

	private final HotelService hotelService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.hotelService.create(hotel));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Hotel hotel){
		return ResponseEntity.ok(this.hotelService.update(hotel));
	}
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok(this.hotelService.listOfAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String hotelID){
		return ResponseEntity.ok(this.hotelService.getByID(hotelID));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String hotelID){
		return ResponseEntity.ok(this.hotelService.getByID(hotelID));
	}
}
