package com.microservice.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservice.hotel.model.ApiResponse;
import com.microservice.hotel.model.Hotel;
import com.microservice.hotel.service.HotelService;
import com.microservice.hotel.constants.MessageConstants;

import java.util.List;

@RestController
@RequestMapping("/v1/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping("/version")
	public String version() {
		return MessageConstants.HOTEL_SERVICE_VERSION;
	}

	// Create a new hotel
	@PostMapping
	public ResponseEntity<ApiResponse> createHotel(@RequestBody Hotel hotel) {
		Hotel savedHotel = hotelService.saveHotel(hotel);
		return new ResponseEntity<>(new ApiResponse("Hotel Registered Successfully", savedHotel), HttpStatus.CREATED);
	}

	// Get all hotels
	@GetMapping("/get_hotels")
	public ResponseEntity<ApiResponse> getAllHotels() {
		List<Hotel> hotels = hotelService.getAllHotels();
		return new ResponseEntity<>(new ApiResponse("Hotel Details Retrieved Successfully", hotels), HttpStatus.OK);
	}

	// Get hotel by ID
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getHotelById(@PathVariable("id") String hotelId) {
		Hotel hotel = hotelService.getHotelById(hotelId);
		return new ResponseEntity<>(new ApiResponse("Hotel Detail Retrieved Successfully", hotel), HttpStatus.OK);
	}

	// Update an existing hotel
	@PutMapping
	public ResponseEntity<ApiResponse> updateHotel(@RequestBody Hotel hotelDetails) {
		Hotel updatedHotel = hotelService.updateHotel(hotelDetails);
		return new ResponseEntity<>(new ApiResponse("Hotel Detail Updated Successfully", updatedHotel), HttpStatus.OK);
	}

	// Delete a hotel by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteHotel(@PathVariable("id") String hotelId) {
		String response = hotelService.deleteHotelById(hotelId);
		return new ResponseEntity<>(new ApiResponse("Hotel Detail Updated Successfully", response), HttpStatus.OK);
	}
}
