package com.vsaini1m.rating.service;

import java.util.List;

import com.vsaini1m.rating.entity.Rating;

public interface RatingService {
	
	Rating create(Rating rating);
	
	Rating update(Rating rating);

	Rating getById(String ratingId);
	
	List<Rating> getAll();
	
	void deleteById(String ratingId);

	List<Rating> getAllByUserId(String id);

	List<Rating> getAllByHotelId(String id);
}
