package com.vsaini1m.hotel.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsaini1m.hotel.entity.Hotel;

@Repository
public interface HotelRepositery extends JpaRepository<Hotel, String> {

}
