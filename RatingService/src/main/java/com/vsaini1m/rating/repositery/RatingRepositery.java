package com.vsaini1m.rating.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsaini1m.rating.entity.Rating;

@Repository
public interface RatingRepositery extends JpaRepository<Rating, String>{

	List<Rating> findAllByUserId(String userId);

	List<Rating> findAllByHotelId(String hotelId);
}
