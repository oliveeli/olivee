package com.olivee.utils.database;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnectionUtil {

	/**
	 * 获取数据库连接
	 * 
	 * @return 数据库连接
	 */
	public static Connection getConnection(DatabaseVender vender,
			String serverAddress, String serverPort, String dbName,
			String jdbcUser, String jdbcPassword)
			throws ClassNotFoundException, SQLException {
		return getConnection(vender, jdbcUser, jdbcPassword, serverAddress,
				serverPort, dbName, 0);
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return 数据库连接
	 */
	public static Connection getConnection(DatabaseVender vender,
			String serverAddress, String serverPort, String dbName,
			String jdbcUser, String jdbcPassword, int timeOut)
			throws ClassNotFoundException, SQLException {

		String jdbcDriver = null;
		String jdbcUrl = null;
		if (DatabaseVender.MS_SQL.equals(vender)) {
			jdbcDriver = JDBCDriver.MS_SQL_JTDS;
			jdbcUrl = "jdbc:jtds:sqlserver://" + serverAddress + ":"
					+ serverPort + "/" + dbName;
		} else if (DatabaseVender.ORACLE.equals(vender)) {
			jdbcDriver = JDBCDriver.ORACLE;
			jdbcUrl = "jdbc:oracle:thin:@" + serverAddress + ":" + serverPort
					+ ":" + dbName;
		} else if (DatabaseVender.MYSQL.equals(vender)) {
			jdbcDriver = JDBCDriver.MYSQL;
			jdbcUrl = "jdbc:mysql://" + serverAddress + ":" + serverPort + "/"
					+ dbName + "";
		}
		if (jdbcDriver == null || jdbcUrl == null) {
			throw new InvalidParameterException("jdbcDriver和jdbcUrl未设置");
		}
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException ex) {
			throw ex;
		}
		if (timeOut > 0) {
			DriverManager.setLoginTimeout(timeOut);
		}
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException ex) {
			throw ex;
		}
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				Logger.getLogger(JDBCConnectionUtil.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				Logger.getLogger(JDBCConnectionUtil.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(JDBCConnectionUtil.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}
}
