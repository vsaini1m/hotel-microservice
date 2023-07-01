package com.vsaini1m.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("resource not found");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
