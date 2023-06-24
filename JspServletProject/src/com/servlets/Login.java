package com.servlets;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;

@WebServlet("/Login")
public class Login extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		LoginDao dao = new LoginDao();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		session.setAttribute("username", username);

		try {
			if (dao.checkDetails(username, password)) { // ClassNotFoundException, SQLException
				response.sendRedirect("Welcome.jsp"); // IOException
			} else {
				response.sendRedirect("Login.jsp");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
