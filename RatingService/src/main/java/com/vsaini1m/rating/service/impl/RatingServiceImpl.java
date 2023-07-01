/**
 * 
 */
package com.vsaini1m.rating.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vsaini1m.rating.dto.Hotel;
import com.vsaini1m.rating.entity.Rating;
import com.vsaini1m.rating.exception.ResourceNotFoundException;
import com.vsaini1m.rating.repositery.RatingRepositery;
import com.vsaini1m.rating.service.RatingService;

import lombok.RequiredArgsConstructor;

/**
 * @author vinit
 *
 */
@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

	private final RatingRepositery ratingRepositery;
	private final RestTemplate restTemplate;
	
	@Override
	public Rating create(Rating rating) {
		rating.setId(UUID.randomUUID().toString());
		return this.ratingRepositery.save(rating);
	}

	@Override
	public Rating update(Rating rating) {
		return this.ratingRepositery.save(rating);
	}

	@Override
	public Rating getById(String ratingId) {
		return this.ratingRepositery.findById(ratingId)
				.orElseThrow(()-> new ResourceNotFoundException("Rating with given id not found !!!"));
	}

	@Override
	public List<Rating> getAll() {
		return this.ratingRepositery.findAll();
	}

	@Override
	public void deleteById(String ratingId) {
		this.ratingRepositery.deleteById(ratingId);
	}

	@Override
	public List<Rating> getAllByUserId(String id) {
		return this.ratingRepositery.findAllByUserId(id).stream().map(rating -> {
			String url = "http://HOTELS/hotels/" + rating.getHotelId();
			Hotel hotel = this.restTemplate.getForObject(url, Hotel.class);
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
	}

	@Override
	public List<Rating> getAllByHotelId(String id) {
		return this.ratingRepositery.findAllByHotelId(id);
	}

}
