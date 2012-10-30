package com.olivee.hrmanager.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.olivee.hrmanager.SystemProperties;

/**
 * Servlet Filter implementation class SystemFilter
 */
public class SystemFilter implements Filter {
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		Object rs = this.getClass().getClassLoader().getResource("datasource.properties");
		SystemProperties.put(SystemProperties.IS_INIT, rs!=null);
	}


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse hResp = (HttpServletResponse)response;
		HttpServletRequest hReq = (HttpServletRequest)request;
		String servletPath = hReq.getServletPath();
		Object isInit = SystemProperties.get(SystemProperties.IS_INIT);
		if(!(Boolean)isInit && servletPath.equalsIgnoreCase("/index.html")){
			hResp.sendRedirect(hReq.getContextPath()  + "/install.html");
			return;
		}
		chain.doFilter(request, response);
	}


	@Override
	public void destroy() {	
	}

}
