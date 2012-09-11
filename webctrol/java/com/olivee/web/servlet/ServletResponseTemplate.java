package com.olivee.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ServletResponseTemplate {
	public static void responseJsonData(HttpServletResponse response,String jsonData) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(jsonData);
		pw.flush();
		pw.close();
	}
}
