package com.olivee.web.excption;

public class WebExcption extends Exception{
	public WebExcption(){
		
	}
	
	public WebExcption(String msg){
		super();
	}
	
	public WebExcption(Throwable ex){
		super(ex);
	}
	
	public WebExcption(String msg,Throwable ex){
		super(msg,ex);
	}
}
