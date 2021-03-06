package com.phonebook.web.contact;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonebook.domain.Contact;
import com.phonebook.domain.impl.ContactImpl;
import com.phonebook.service.ContactService;
import com.phonebook.service.impl.ContactServiceImpl;
import com.phonebook.util.ValidationUtils;

public class ContactController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contact contact = new ContactImpl();
		contact.setName(request.getParameter("name"));
		contact.setEmail(request.getParameter("email"));
		contact.setMobile(request.getParameter("mobile"));
		Map<String, Object> errors = ValidationUtils.validate(contact);
		if ((boolean) errors.get("hasErrors")) {
			request.setAttribute("contact", contact);
			request.setAttribute("errors", errors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("contact.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		ContactService contactService = new ContactServiceImpl();
		try {
			contact = contactService.save(contact);
		} catch (Exception ex) {
			System.out.println("ex");
		}
		response.sendRedirect("list");
	}

}
