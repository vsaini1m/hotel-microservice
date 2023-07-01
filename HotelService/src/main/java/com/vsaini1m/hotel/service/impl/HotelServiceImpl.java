package com.vsaini1m.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.vsaini1m.hotel.entity.Hotel;
import com.vsaini1m.hotel.exception.ResourceNotFoundException;
import com.vsaini1m.hotel.repositery.HotelRepositery;
import com.vsaini1m.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

	private final HotelRepositery hotelRepositery;

	@Override
	public Hotel create(Hotel hotel) {
		hotel.setId(UUID.randomUUID().toString());
		return this.hotelRepositery.save(hotel);
	}

	@Override
	public Hotel update(Hotel hotel) {
		return this.hotelRepositery.save(hotel);
	}

	@Override
	public Hotel getByID(String hotelID) {
		return this.hotelRepositery.findById(hotelID)
				.orElseThrow(()-> new ResourceNotFoundException("Hotel with given id not found !!"));
	}

	@Override
	public List<Hotel> listOfAll() {
		return this.hotelRepositery.findAll();
	}

	@Override
	public void deleteByID(String hotelID) {
		this.hotelRepositery.deleteById(hotelID);
	}
	
	
}
