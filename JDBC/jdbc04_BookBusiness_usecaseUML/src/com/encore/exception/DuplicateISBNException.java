package com.encore.exception;

public class DuplicateISBNException extends Exception{
	public DuplicateISBNException(){
		this("This ISBN already exists...");
	}
	public DuplicateISBNException(String message){
		super(message);
	}
}
