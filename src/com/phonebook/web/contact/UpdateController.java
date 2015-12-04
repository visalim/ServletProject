package com.phonebook.web.contact;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phonebook.domain.Contact;
import com.phonebook.service.ContactService;
import com.phonebook.service.impl.ContactServiceImpl;
import com.phonebook.util.ValidationUtils;

public class UpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contact contact = null;
		ContactService contactService = new ContactServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			contact = contactService.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

		try {

			contact = contactService.update(contact);
		} catch (Exception ex) {
			System.out.println("ex");
		}
		response.sendRedirect("list");
	}

}
