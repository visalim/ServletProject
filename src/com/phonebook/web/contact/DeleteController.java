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

public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contact contact = null;
		ContactService contactService = null;
		int id = Integer.parseInt(request.getParameter("id"));
		contactService = new ContactServiceImpl();
		try {
			contact = contactService.get(id);
		} catch (Exception ex) {
			System.out.println("ex");
		}
		if (contact == null) {
			request.setAttribute("error", "record with given id doesnot exists");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("list");
			requestDispatcher.forward(request, response);
		} else{
			try {
				contactService.delete(id);
			} catch (Exception ex) {
				System.out.println("ex");
			}
			response.sendRedirect("list");
		}
	}

}
