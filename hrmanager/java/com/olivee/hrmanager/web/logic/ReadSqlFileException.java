package com.olivee.hrmanager.web.logic;

@SuppressWarnings("serial")
public class ReadSqlFileException extends Exception{
	
	public ReadSqlFileException(){}
	
	public ReadSqlFileException(String message){super(message);}
	
	public ReadSqlFileException(String message,Throwable e){super(message,e);}

}
