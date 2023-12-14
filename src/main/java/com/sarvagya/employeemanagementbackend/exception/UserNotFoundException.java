package com.sarvagya.employeemanagementbackend.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(Long id) {
		super("User Not Found with id " + id);
	}

}
