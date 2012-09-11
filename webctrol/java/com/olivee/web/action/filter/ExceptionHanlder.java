package com.olivee.web.action.filter;

public class ExceptionHanlder {

	public void handleException(String string) {
		System.out.println(string);
	}

	public void handleException(String string, Throwable e) {
		e.printStackTrace();
		System.out.println(string + e.getLocalizedMessage());
		
	}

	

}
