package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/square")
public class SquareServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Request Dispatcher
		// -------------------
//		int k = (int) request.getAttribute("K");
//
//		k = k * k;
//		PrintWriter out = response.getWriter();
//		out.println("The Square is: " + k);

		// Redirect
		// --------
//		 int k = Integer.parseInt(request.getParameter("K"));
//		 k = k * k;
//		 PrintWriter out = response.getWriter();
//		 out.println("The Square using Redirect is: " + k);

		// Session
		// --------
//		HttpSession session = request.getSession();
//		int k = (int) session.getAttribute("K");
//		
//		k = k * k;
//		PrintWriter out = response.getWriter();
//		out.println("The Square using Session is: " + k);

		// Cookie
		// -------
		int k = 0;
		Cookie cookiesArr[] = request.getCookies();
		
		for(Cookie c: cookiesArr) {
			if(c.getName().equals("K")) {
				k = Integer.parseInt(c.getValue());			}
		}
		
		k = k * k;
		PrintWriter out = response.getWriter();
		out.println("The Square using Cookie is: " + k);

	}
}
