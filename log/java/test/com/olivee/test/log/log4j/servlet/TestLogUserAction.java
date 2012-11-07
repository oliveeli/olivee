package com.olivee.test.log.log4j.servlet;

import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.olivee.log.log4j.OliveeAppender;


public class TestLogUserAction {
	
	private Appender getUserActionServerAppender(Logger logger){
		Enumeration<Appender> ap = logger.getAllAppenders();
		while(ap.hasMoreElements()){
			Appender a = ap.nextElement();
			if(a instanceof OliveeAppender){
				return a;
			}
		}
		return null;
	}
	
	private boolean haveUserActionServerAppender(){
		String catalog = "USER.ACTION";
		Enumeration<Logger> catalogs = LogManager.getLoggerRepository().getCurrentCategories();
		while(catalogs.hasMoreElements()){
			Logger o = catalogs.nextElement();
			String name = o.getName();
			if(catalog.equals(name)){
				Appender a = getUserActionServerAppender(o);
				if(a!=null){
					o.setLevel(Level.ALL);
					return true;
				}
			}
		}
		return false;
	}
	
	public void setUserActionAppender(){
		if(!haveUserActionServerAppender()){
			Logger root = LogManager.getRootLogger();
			Appender a = getUserActionServerAppender(root);
			if(root.getLevel().equals(Level.ALL) && a!=null){
				
			} if(!root.getLevel().equals(Level.ALL) && a!=null){
				Properties properties2 = new Properties();
				properties2.put("log4j.logger.USER.ACTION", "ALL");
				new PropertyConfigurator().doConfigure(properties2, LogManager.getLoggerRepository());
			} else {
				Properties properties2 = new Properties();
				properties2.put("log4j.logger.USER.ACTION", "ALL,userActionServerAppender");
				properties2.put("log4j.appender.userActionServerAppender", "com.olivee.log.log4j.OliveeAppender");
				new PropertyConfigurator().doConfigure(properties2, LogManager.getLoggerRepository());
			}
		}
	}
	

	public void login(){
		
		
		
		Logger.getLogger("USER.ACTION").info("LOGIN");
		Logger.getLogger("11").info("11");
		
	}
	
	public static void main(String[] args){
		new TestLogUserAction().login();
	}
	
	
}
