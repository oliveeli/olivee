package com.olivee.utils.image;

public class ImageResizeException extends Exception{
	
	public ImageResizeException(){
		
	}
	
	public ImageResizeException(String message){
		super(message);
	}
	
	public ImageResizeException(String message, Throwable ex){
		super(message,ex);
	}
	
}
