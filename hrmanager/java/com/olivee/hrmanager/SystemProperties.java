package com.olivee.hrmanager;

import java.util.HashMap;
import java.util.Map;

public class SystemProperties {
	
	public static final String IS_INIT = "INIT";
	public static final String WEB_CONTEXT_PATH = "WEB_CONTEXT_PATH";
	public static final String WEB_INF_CLASSES_PATH = "WEB_INF_CLASSES_PATH";
	public static final String SUPPER_USER_NAME = "SUPPER_USER_NAME";
	public static final String SUPPER_USER_PASSWORD = "SUPPER_USER_PASSWORD";
	
	private static Map<Object, Object> properties = new HashMap<Object, Object>();
	
	public static void put(Object k, Object v){
		properties.put(k, v);
	}
	
	public static Object get(Object k){
		return properties.get(k);
	}
	
	public static void remove(Object k){
		properties.remove(k);
	}
}
