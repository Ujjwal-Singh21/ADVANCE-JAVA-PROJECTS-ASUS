package com.mavenproject.controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mavenproject.dao.AlienDao;
import com.mavenproject.model.Alien;

public class AlienController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
		
		AlienDao dao = new AlienDao();
	
		try {
			Alien alien = dao.getAlien(aid);
			
			request.setAttribute("alien", alien);
			RequestDispatcher rd = request.getRequestDispatcher("ShowAlien.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
