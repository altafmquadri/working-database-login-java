package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Login;
import com.service.UserService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		Login login = new Login(request.getParameter("emp-name"), request.getParameter("email"));

		boolean verified = userService.login(login);

		if (verified) {
			response.getWriter().println("You have logged in succesfully");
		} else {
			response.getWriter().println("Login failed");
		}

	}

}
