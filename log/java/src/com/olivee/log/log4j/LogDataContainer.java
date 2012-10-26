package com.olivee.log.log4j;

import java.util.ArrayList;

public class LogDataContainer {
	private ArrayList<LogData> arrList = new ArrayList<LogData>();

	public synchronized void put(LogData o) {
		arrList.add(o);
	}

	public synchronized LogData get() {
		if(arrList.size()>0){
			LogData data = arrList.get(0);
			arrList.remove(0);
			return data;
		}
		return null;
	}
}
