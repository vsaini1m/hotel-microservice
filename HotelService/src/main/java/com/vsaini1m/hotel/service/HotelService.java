package com.vsaini1m.hotel.service;

import java.util.List;

import com.vsaini1m.hotel.entity.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);
	
	Hotel update(Hotel hotel);
	
	Hotel getByID(String hotelID);
	
	List<Hotel> listOfAll();
	
	void deleteByID(String hotelID);
	
	
}
