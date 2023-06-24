package com.servlets;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstl-servlet")
public class JstlServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String name = "Ujjwal JSTL Demo";
		Student student = new Student(1, "Steve");
		
		List<Student> studentsList = Arrays.asList(new Student(1, "Steve"), new Student(2, "Clarke"), new Student(3, "Diana"));
		
		request.setAttribute("label", name);
		request.setAttribute("student", student);
		request.setAttribute("students", studentsList);
		
		RequestDispatcher rd = request.getRequestDispatcher("JSTL.jsp");
		rd.forward(request, response);
		
	}
}
