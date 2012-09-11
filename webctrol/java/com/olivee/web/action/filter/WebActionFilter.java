package com.olivee.web.action.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WebActionFilter implements Filter{
	
	private String servletPathPrefix,javaPackagePrefix;
	
	ExceptionHanlder exceptionHanlder;	



	public void destroy() {
		
		
	}


	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		
		String servlentName = request.getServletPath();
		
		
		if(!servlentName.startsWith(servletPathPrefix)){
			exceptionHanlder.handleException("Action not start with '"+ servletPathPrefix +"'");
			return;
		}
		
		String actionName = servlentName.substring(servletPathPrefix.length());
		String methodName = "";
		if(actionName.equals("")){
			exceptionHanlder.handleException("Action can not found by '"+ actionName +"'");
		}
		if(actionName.endsWith(".do")){
			actionName = actionName.substring(0, actionName.length()-3);
		}
		
		
		
		if(actionName.indexOf("!")>-1){
			int index = actionName.indexOf("!");
			methodName = actionName.substring(index+1);
			actionName = actionName.substring(0,index);
		}
		
		if(methodName==null || methodName.trim().equals("")){
			methodName = "execute";
		}
		
		if(actionName.equals("")){
			exceptionHanlder.handleException("Action can not found by '"+ actionName +"'");
			return;
		}
		
		actionName = actionName.replaceAll("/", ".");
		
		actionName = javaPackagePrefix + actionName + ".MainAction";
		WebAction action = null;
		Class actionClass = null;
		try {
			actionClass = Class.forName(actionName);
			Object actionObject = actionClass.newInstance();
			if(!(actionObject instanceof WebAction)){
				exceptionHanlder.handleException("Action "+ actionName +" is not instanceof WebAction!");
				return;
			}
			action = (WebAction)actionObject;
		} catch (ClassNotFoundException e) {
			exceptionHanlder.handleException("Action can not found by '"+ actionName +"'");
			return;
		} catch (InstantiationException e) {
			exceptionHanlder.handleException("Action "+ actionName +" newInstance exception!" + e.getLocalizedMessage());
			return;
		} catch (IllegalAccessException e) {
			exceptionHanlder.handleException("Action "+ actionName +" newInstance can not found!");
			return;
		}
		
		
		Method method = null;
		
		try {
			method = actionClass.getMethod(methodName, new Class[]{HttpServletRequest.class,HttpServletResponse.class});
		} catch (SecurityException e) {
			exceptionHanlder.handleException("Action "+ actionName +" method "+ methodName +"(request, response) can not found!");
			return;
		} catch (NoSuchMethodException e) {
			exceptionHanlder.handleException("Action "+ actionName +" no method "+ methodName +"(request, response) !");
			return;
		}
		
		try {
			method.invoke(action, new Object[]{request,(HttpServletResponse)servletResponse});
		} catch (Throwable e) {
			exceptionHanlder.handleException("Invoke action method exception!",e);
		}
		PrintWriter pw = servletResponse.getWriter();
		pw.write(actionName + "<br/>" + methodName);
		pw.close();
		
		
		
	}


	public void init(FilterConfig filterConfig) throws ServletException {
		servletPathPrefix = filterConfig.getInitParameter("action-servletpath-prefix");
		if(servletPathPrefix==null){
			servletPathPrefix = "";
		}
		javaPackagePrefix = filterConfig.getInitParameter("action-package-prefix");
		if(javaPackagePrefix==null){
			javaPackagePrefix = "";
		}
		
		exceptionHanlder = new ExceptionHanlder();
		
		
	}



}
