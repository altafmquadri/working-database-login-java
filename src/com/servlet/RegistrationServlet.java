package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;
import com.service.UserService;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		Employee employee = new Employee(request.getParameter("emp-name"),request.getParameter("email"),request.getParameter("city"));
		
		boolean isRegistered = userService.register(employee);
		
		if (isRegistered) {
			response.getWriter().println("User is successfully registered");
		}else {
			response.getWriter().println("Registration failed");
			
		}
				
	}

}
