package com.evs.main.customexceptions.handler;

import java.util.Date;

import lombok.Data;

@Data
public class ApiResponse {

	private Date timestamp;
	private String message;
	private String details;
}
