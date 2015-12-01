package com.phonebook.web.contact;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phonebook.domain.Contact;
import com.phonebook.service.ContactService;
import com.phonebook.service.impl.ContactServiceImpl;

public class UpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contact contact = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		ContactService contactService = new ContactServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			contact = contactService.get(id);
		} catch (Exception ex) {
			System.out.println("ex");
		}
		contact.setId(id);
		contact.setName(name);
		contact.setEmail(email);
		contact.setMobile(mobile);
		try {
			contact = contactService.update(contact);
		} catch (Exception ex) {
			System.out.println("ex");
		}
		response.sendRedirect("list");

	}

}
