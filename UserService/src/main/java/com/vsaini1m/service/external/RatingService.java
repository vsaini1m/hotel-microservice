/**
 * 
 */
package com.vsaini1m.service.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vsaini1m.entity.Rating;

/**
 * @author vinit
 *
 */
@FeignClient(name = "RATINGS")
public interface RatingService {
	
	@GetMapping("ratings/user/{userId}")
	public List<Rating> getRatingsByUserId(@PathVariable String userId);

	@GetMapping("ratings/hotel/{userId}")
	public List<Rating> getRatingsByHotelId(@PathVariable String userId);

}
