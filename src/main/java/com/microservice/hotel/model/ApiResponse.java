package com.microservice.hotel.model;

import com.microservice.hotel.constants.MessageConstants;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservice.hotel.constants.MessageConstants;

public class ApiResponse {
	public int status;
	public String datetime;
	public String statusdescription;
	public String message;
	public Object data;

	public ApiResponse(int errorStatusCode, String errorMessage) {
		this.status = errorStatusCode;
		this.datetime = MessageConstants.sd.format(new Date());
		this.statusdescription = "ERROR";
		this.message = errorMessage;
	}

	public ApiResponse(String errorMessage, Object successData) {
		this.status = 200;
		this.datetime = MessageConstants.sd.format(new Date());
		this.statusdescription = "SUCCESS";
		this.message = errorMessage;
		this.data = successData;
	}

}