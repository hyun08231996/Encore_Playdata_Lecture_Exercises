package com.encore.exception;

public class BookNotFoundException extends Exception{
	public BookNotFoundException(){
		this("Book cannot be found...");
	}
	public BookNotFoundException(String message){
		super(message);
	}
}
