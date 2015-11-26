package com.phonebook.web.login;

import java.awt.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonebook.domain.User;
import com.phonebook.service.UserService;
import com.phonebook.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();

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
		User user = userservice.findByEmailAndPassword(newEmail, newPassword);
		if (user != null) {
			response.sendRedirect("list");
		} else {
			request.setAttribute("error", "Invalid username/password");
			//response.sendRedirect("login.jsp");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);

		}

	}
}
