package com.olivee.web.action.filter;

import com.olivee.web.excption.WebExcption;

public class ActionNotFoundException extends WebExcption {
	public ActionNotFoundException(String msg){
		super();
	}
	
	public ActionNotFoundException(Throwable ex){
		super(ex);
	}
	
	public ActionNotFoundException(String msg,Throwable ex){
		super(msg,ex);
	}
}
