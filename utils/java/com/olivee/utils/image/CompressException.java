package com.olivee.utils.image;

public class CompressException extends Exception{
	
	public CompressException(){
		
	}
	
	public CompressException(String message){
		super(message);
	}
	
	public CompressException(String message, Throwable ex){
		super(message,ex);
	}
	
}
