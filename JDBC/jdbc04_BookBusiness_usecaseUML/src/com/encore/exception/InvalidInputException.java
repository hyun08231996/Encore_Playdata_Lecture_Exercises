package com.encore.exception;

public class InvalidInputException extends Exception{
	public InvalidInputException(){
		this("Min and max are incorrect...");
	}
	public InvalidInputException(String message){
		super(message);
	}
}
