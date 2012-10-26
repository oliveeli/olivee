package com.olivee.test.log.log4j.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class TestLogServlet
 */
public class TestLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(TestLogServlet.class);
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestLogServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("start servet TestLogServlet!");
		try {
			logger.debug("Parse aa to int.");
			Integer.parseInt("aa");
		} catch (NumberFormatException e) {
			logger.error("Error Text!", e);
		}
		response.getWriter().write("aaa");
		logger.info("end servet TestLogServlet!");
	}

}
