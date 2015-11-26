package com.phonebook.web.list;

import java.io.IOException;
import com.phonebook.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ListController")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ListController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
		requestDispatcher.forward(request, response);

	}
}
