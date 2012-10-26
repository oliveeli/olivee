package com.olivee.log.log4j;

public class ServiceInvokerLogic {
	public void saveLogData(LogData logData){
		long b = System.currentTimeMillis();
		while(System.currentTimeMillis()-b < 1000){
			
		}
		System.out.println(logData.getMessage());
	}
}
