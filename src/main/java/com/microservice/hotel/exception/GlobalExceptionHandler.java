package com.microservice.hotel.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.microservice.hotel.model.ApiResponse;
import lombok.Builder;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourseNotFoundException(ResourseNotFoundException exception) {
		return new ResponseEntity<>(new ApiResponse(exception.getStatusCode(), exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}
}
