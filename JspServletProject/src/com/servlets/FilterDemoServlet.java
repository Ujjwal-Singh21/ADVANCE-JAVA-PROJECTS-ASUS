package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addAlien")
public class FilterDemoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int aliendId = Integer.parseInt(req.getParameter("aid"));
		String alienName = req.getParameter("aname");
		
		PrintWriter out = res.getWriter();
		out.print("Welcome " + aliendId + " with Name " + alienName);
	}
}
