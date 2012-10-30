package com.olivee.hrmanager.web.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.olivee.hrmanager.SystemProperties;
import com.olivee.hrmanager.install.entity.DatabaseConfig;
import com.olivee.hrmanager.install.entity.User;
import com.olivee.hrmanager.web.action.ResultMessage;
import com.olivee.hrmanager.web.action.ResultType;
import com.olivee.utils.database.DatabaseVender;
import com.olivee.utils.database.JDBCConnectionUtil;
import com.olivee.utils.security.MD5Encoder;

@Service
public class SystemInstallLogic {

	public ResultMessage saveDbConfig(DatabaseConfig dbConfig) {
		ResultMessage result = new ResultMessage();
		String classesPath = (String) SystemProperties
				.get(SystemProperties.WEB_INF_CLASSES_PATH);
		if (!new File(classesPath).exists()) {
			new File(classesPath).mkdirs();
		}
		try {
			Connection conn = JDBCConnectionUtil.getConnection(
					DatabaseVender.MYSQL, dbConfig.getAddress(),
					dbConfig.getPort(), dbConfig.getInstance(),
					dbConfig.getUser(), dbConfig.getPassword(), 2);
		} catch (Exception e) {
			result.setType(ResultType.ERROR);
			result.setData("Connection failed!" + e.getMessage());
			return result;
		}
		
		Properties props = new Properties();
		props.setProperty("datasource.driver", "com.mysql.jdbc.Driver");
		props.setProperty(
				"datasource.url",
				"jdbc:mysql://".concat(dbConfig.getAddress()).concat(":")
						.concat(dbConfig.getPort()).concat("/")
						.concat(dbConfig.getInstance()));
		props.setProperty("datasource.user", dbConfig.getUser());
		props.setProperty("datasource.password", dbConfig.getPassword());
		File propFile = new File(classesPath + "/datasource.properties");
		
		try {
			if(propFile.exists()){
				propFile.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(propFile);
			props.store(fos,"");
		} catch (Exception e) {
			result.setType(ResultType.ERROR);
			result.setData("Store failed!" + e.getMessage());
			return result;
		}
		
		result.setType(ResultType.SUCCESS);
		return result;
	}
	
	private void executeInstallDbSql(){
		
	}

	public ResultMessage adminConfig(User user) {
		ResultMessage result = new ResultMessage();
		if("".equals(user.getName()) || "".equals(user.getPassword())){
			result.setType(ResultType.ERROR);
			result.setData("User name and password shoud not be null!");
			return result;
		}
		
	
		Properties props = new Properties();

		props.setProperty("user", user.getName());

		props.setProperty("password", MD5Encoder.encode(user.getPassword()));
		
		String classesPath = (String) SystemProperties
				.get(SystemProperties.WEB_INF_CLASSES_PATH);
		if (!new File(classesPath).exists()) {
			new File(classesPath).mkdirs();
		}
		File propFile = new File(classesPath + "/admin.properties");
		
		try {
			if(propFile.exists()){
				propFile.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(propFile);
			props.store(fos,"");
		} catch (Exception e) {
			result.setType(ResultType.ERROR);
			result.setData("Store failed!" + e.getLocalizedMessage());
			return result;
		}
		
		result.setType(ResultType.SUCCESS);
		return result;
	}

}
