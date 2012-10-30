package com.olivee.utils.io;

public class FileUtil {
	
	/**
	 * 
	 * @return 文件后缀名
	 */
	public static String getFileSuffix(String fileName){
		int pointIndex = fileName.lastIndexOf(".");
		if(pointIndex<0){
			return "";
		}
		return fileName.substring(pointIndex + 1);
	}
	
}
