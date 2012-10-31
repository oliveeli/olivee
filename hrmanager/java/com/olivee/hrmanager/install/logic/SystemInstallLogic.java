package com.olivee.hrmanager.install.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.olivee.hrmanager.SystemProperties;
import com.olivee.hrmanager.install.entity.DatabaseConfig;
import com.olivee.hrmanager.install.entity.User;
import com.olivee.hrmanager.web.action.ResultMessage;
import com.olivee.hrmanager.web.action.ResultType;
import com.olivee.hrmanager.web.logic.ReadSqlFileException;
import com.olivee.utils.database.DatabaseVender;
import com.olivee.utils.database.JDBCConnectionUtil;
import com.olivee.utils.security.MD5Encoder;

@Service
public class SystemInstallLogic {
	
	public Logger logger = Logger.getLogger(SystemInstallLogic.class);

	public ResultMessage saveDbConfig(DatabaseConfig dbConfig) {
		
		logger.debug("save database config begin " + dbConfig);
		ResultMessage result = new ResultMessage();
		String classesPath = (String) SystemProperties
				.get(SystemProperties.WEB_INF_CLASSES_PATH);
		if (!new File(classesPath).exists()) {
			new File(classesPath).mkdirs();
		}
		Connection conn = null;
		try {
			conn = JDBCConnectionUtil.getConnection(
					DatabaseVender.MYSQL, dbConfig.getAddress(),
					dbConfig.getPort(), dbConfig.getInstance(),
					dbConfig.getUser(), dbConfig.getPassword(), 2);
		} catch (Exception e) {
			logger.error("save dbconfig error, database connection error", e);
			result.setType(ResultType.ERROR);
			result.setData("Connection failed!" + e.getMessage());
			return result;
		} finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {}
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
			logger.error("save dbconfig error, save config file error", e);
			result.setType(ResultType.ERROR);
			result.setData("Store failed!" + e.getMessage());
			return result;
		}
		
		try {
			this.executeInstallDbSql(dbConfig);
		} catch (Exception e) {
			result.setType(ResultType.ERROR);
			result.setData("Store failed!" + e.getMessage());
			return result;
		}
		
		result.setType(ResultType.SUCCESS);
		logger.debug("save database config end " + dbConfig);
		return result;
	}
	
	private void executeInstallDbSql(DatabaseConfig dbConfig) throws FileNotFoundException, ReadSqlFileException, SQLException{
		logger.debug("execute install database sql begin");
		List<String> sqlList = this.getInstallSql();
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JDBCConnectionUtil.getConnection(
					DatabaseVender.MYSQL, dbConfig.getAddress(),
					dbConfig.getPort(), dbConfig.getInstance(),
					dbConfig.getUser(), dbConfig.getPassword());
			for(String sql:sqlList){
				try {
					logger.debug("execute install database sql:" + sql);
					stmt = conn.createStatement();
					stmt.execute(sql);
				} catch (Exception e) {
					logger.warn("execute sql["+ sql +"] error", e);
				} finally {
					stmt.close();
				}
			}
			
		} catch (Exception e) {
			logger.error("execute install sql error", e);
			throw new SQLException(e);
		} finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
		logger.debug("execute install database sql end");
	}
	
	public List<String> getInstallSql() throws FileNotFoundException, ReadSqlFileException{
		logger.debug("get install database sql begin");
		InputStream in;
		try {
			in = this.getClass().getClassLoader().getResourceAsStream("com/olivee/hrmanager/install/logic/install_mysql.sql");
		} catch (Exception e) {
			logger.error("get install database sql error, com/olivee/hrmanager/install/logic/install_mysql.sql file not found", e);
			throw new FileNotFoundException("install_mysql.sql file not found!");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		List<String> sqlList = new ArrayList<String>();
		
		try {
			String sql = "";
			for(String line=null;(line=br.readLine())!=null;){
				sql = sql.concat(line);
				if(line.endsWith(";")){
					sqlList.add(sql);
					sql = "";
				}
			}
		} catch (Exception e) {
			logger.error("get install database sql error", e);
			throw new ReadSqlFileException("install_mysql.sql read error", e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
			try {
				in.close();
			} catch (IOException e) {
			}
		}
		logger.debug("get install database sql end");
		return sqlList;
	}

	public ResultMessage adminConfig(User user) {
		logger.debug("condig administrator user begin " + user);
		ResultMessage result = new ResultMessage();
		if("".equals(user.getName()) || "".equals(user.getPassword())){
			logger.debug("condig administrator user error, User name and password shoud not be null");
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
			logger.error("condig administrator user error", e);
			result.setType(ResultType.ERROR);
			result.setData("Store failed!" + e.getLocalizedMessage());
			return result;
		}
		
		result.setType(ResultType.SUCCESS);
		logger.debug("condig administrator user end " + user);
		return result;
	}

}
