package com.vsaini1m.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

	private String id;
	private String userId;
	private String hotelId;
	private String rating;
	private String feedback;
}
