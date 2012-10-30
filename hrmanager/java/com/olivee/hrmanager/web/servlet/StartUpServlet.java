package com.olivee.hrmanager.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.olivee.hrmanager.SystemProperties;

/**
 * Servlet implementation class StartUpServlet
 */
public class StartUpServlet extends HttpServlet {
	
	private static final Log log = LogFactory.getLog(StartUpServlet.class);
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		log.info("init system properties!");
		
		String contextPath = config.getServletContext().getRealPath("");
		SystemProperties.put(SystemProperties.WEB_CONTEXT_PATH, contextPath); 
		SystemProperties.put(SystemProperties.WEB_INF_CLASSES_PATH, contextPath + "/WEB-INF/classes");
		
		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("admin.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			SystemProperties.put(SystemProperties.SUPPER_USER_NAME, prop.get("user"));
			SystemProperties.put(SystemProperties.SUPPER_USER_PASSWORD, prop.get("password"));
		} catch (Throwable e) {
			log.error("load admin config failed!", e);
			SystemProperties.put(SystemProperties.IS_INIT, false);
		}
		
	}

}
