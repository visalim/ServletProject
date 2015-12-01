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

public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserController() {
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
		User user = null;
		try {
			user = userservice.findByEmail(email);
		} catch (Exception ex) {
			System.out.println("ex");
		}
		if (user != null) {
			request.setAttribute("error", "user exists with the given emaailid");
			RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		} else {
			user = new UserImpl();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			try {
				user = userservice.save(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (user != null) {
				response.sendRedirect("login");
			}
		}
	}

}