package com.phonebook.web.contact;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phonebook.domain.Contact;
import com.phonebook.service.ContactService;
import com.phonebook.service.impl.ContactServiceImpl;

public class EditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contact contact = null;
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			ContactService contactService = new ContactServiceImpl();
			try {
				contact = contactService.get(id);
			} catch (Exception ex) {
				System.out.println("ex");
			}
			if (contact == null) {
				RequestDispatcher rd = request.getRequestDispatcher("list");
				rd.forward(request, response);
			}
			request.setAttribute("contact", contact);
			RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
			rd.forward(request, response);
		}

	}

}
