package com.vsaini1m.rating.entity;

import com.vsaini1m.rating.dto.Hotel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {

	@Id
	private String id;
	private String userId;
	private String hotelId;
	private String rating;
	private String feedback;
	@Transient
	private Hotel hotel;
}