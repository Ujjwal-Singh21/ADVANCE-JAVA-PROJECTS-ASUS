package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		int k = i + j;
		
		PrintWriter out = response.getWriter();
		out.println("The result is: " + k);
		
		// forwarding a request from one servlet to another servlet (From AddServlet to SquareServlet)
		// It can be done using RequestDispatcher(I) or Redirect
		// request.getRequestDispatcher("square") returns instance of RequestDispatcher(I)
		//----------------------------------------------------------------------------------------------
//		request.setAttribute("K", k);
//		RequestDispatcher rd = request.getRequestDispatcher("square");	
//		rd.forward(request, response);
		
		// Redirect using URL-Rewriting 
		//------------------------------
//		response.sendRedirect("square?K=" + k);
		
		// Redirect using Sesion
		//----------------------
//		HttpSession session = request.getSession();
//		session.setAttribute("K", k);
//		response.sendRedirect("square");
		
		// Redirect using Cookies
		//-----------------------
//		Cookie cookie = new Cookie("K", k + "");
//		response.addCookie(cookie);
//		response.sendRedirect("square");
	}
}
