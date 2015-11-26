package com.phonebook.web.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonebook.domain.User;
import com.phonebook.domain.impl.UserImpl;
import com.phonebook.service.UserService;
import com.phonebook.service.impl.UserServiceImpl;

//@WebServlet("/user")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userservice = new UserServiceImpl();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userservice.findByEmail(email);
		if (user!=null) {
			request.setAttribute("error", "user exists with the given emaailid");
			RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		} else {
			user = new UserImpl();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user = userservice.save(user);
			if (user != null) {
				response.sendRedirect("login");
			}
		}
	}
}