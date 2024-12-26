package com.microservice.hotel.exception;

import lombok.Data;

@Data
public class ResourseNotFoundException extends RuntimeException {
	private int statusCode;
	private String message;

	public ResourseNotFoundException(int statusCode, String message) {
//		super(message);
		this.statusCode = statusCode;
		this.message = message;
	}
}
