package com.olivee.log.log4j.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.MDC;

/**
 * Servlet Filter implementation class MDCFilter
 */
public class MDCFilter implements Filter {
	
	public final static String USER_ID = "requestUserId";
	public final static String USER_NAME = "requestUserName";
	public final static String USER_SERVLET = "requestServlet";
	public final static String USER_IP = "requestRemoteIp";

    /**
     * Default constructor. 
     */
    public MDCFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		storeMDC(request);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	private void storeMDC(ServletRequest request){
		try {
			HttpServletRequest hReq = (HttpServletRequest)request;
			
			String url = hReq.getServletPath();
			String qStr = hReq.getQueryString();
			if(qStr!=null){
				url = url.concat("?").concat(qStr);
			}
			
			MDC.put(USER_ID, "ID1234567890");
			MDC.put(USER_NAME, "NAME987654321");
			MDC.put(USER_SERVLET, url);
			MDC.put(USER_IP, hReq.getRemoteAddr());

		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

}
