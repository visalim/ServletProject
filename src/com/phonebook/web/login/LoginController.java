package com.phonebook.web.login;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phonebook.domain.User;
import com.phonebook.service.UserService;
import com.phonebook.service.impl.UserServiceImpl;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newEmail = request.getParameter("email");
		String newPassword = request.getParameter("password");
		UserService userservice = new UserServiceImpl();
		User user = null;
		try {
			user = userservice.findByEmailAndPassword(newEmail, newPassword);
		} catch (Exception ex) {
			System.out.println("ex");
		}
		if (user != null) {
			response.sendRedirect("list");
		} else {
			request.setAttribute("error", "Invalid username/password");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
