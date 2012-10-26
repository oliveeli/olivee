package com.olivee.test.log.log4j.servlet;

import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestLogUserAction {
	

	public void login(){
		
		Properties properties = new Properties();
		properties.put("log4j.logger.USER.ACTION", "ALL");
		new PropertyConfigurator().doConfigure(properties, LogManager.getLoggerRepository());
		
		Logger.getLogger("USER.ACTION.LOGIN").info("start");
	}
	
	public static void main(String[] args){
		new TestLogUserAction().login();
	}
	
	
}
