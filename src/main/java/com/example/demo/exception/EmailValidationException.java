package com.example.demo.exception;

public class EmailValidationException extends RuntimeException{
	
	public  EmailValidationException(String message) {
		super (message);
	}
	
	
	  public static EmailValidationException noFoundEmail() {
	        return new EmailValidationException("No se encontro el email");
	    }

	    public static EmailValidationException passwordInvalidate() {
	        return new EmailValidationException("Password no valido");
	    }
	
	
}
