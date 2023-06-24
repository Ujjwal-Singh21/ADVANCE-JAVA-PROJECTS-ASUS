package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Both are used to get initial values for servlet or for Application.
// ServletConfig is available separately for every Servlet class
// ServletContext is common to all Servlets.
//---------------------------------------------------------------------

//@WebServlet("/home")
public class ServletContextAndConfig extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		out.println("Hi ");
	
		ServletContext context = request.getServletContext();
		String name = context.getInitParameter("Name");
		out.println(name);
		
		ServletConfig config = getServletConfig();
		String name1 = context.getInitParameter("Name");
		out.println(name1);
		
	}
}
