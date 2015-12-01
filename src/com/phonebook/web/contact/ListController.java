package com.phonebook.web.contact;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phonebook.domain.impl.ContactImpl;
import com.phonebook.service.ContactService;
import com.phonebook.service.impl.ContactServiceImpl;

public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContactService contactservice = new ContactServiceImpl();
		List<ContactImpl> contacts = null;
		try {
			contacts = contactservice.list();
		} catch (Exception ex) {
			System.out.println("ex");
		}
		request.getSession().setAttribute("List", contacts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

}