package com.olivee.test.log.log4j;

import org.apache.log4j.Logger;

public class TestLogTime {
	
	private static Logger logger = Logger.getLogger(TestLogTime.class);
	
	public static void main(String[] args){
		long begin = System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			logger.info("test mesgtest mesgtest mesgtest mesgtest mesgtest mesgtest mesgtest mesgmesgtest mesgtest mesgmesgtest mesgtest mesgmesgtest mesgtest mesgmesgtest mesgtest mesg");
		}
		long durring = System.currentTimeMillis() - begin;
		System.out.println("durring=" + durring);
	}
}
