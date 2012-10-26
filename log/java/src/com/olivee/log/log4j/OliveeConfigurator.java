package com.olivee.log.log4j;

import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class OliveeConfigurator {
	public static void enableUserActionLog(){
		Properties properties = new Properties();
		properties.put("log4j.logger.USER.ACTION", "ALL");
		new PropertyConfigurator().doConfigure(properties, LogManager.getLoggerRepository());
	}
}
