package com.phonebook.web.contact;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phonebook.domain.Contact;
import com.phonebook.domain.impl.ContactImpl;
import com.phonebook.service.ContactService;
import com.phonebook.service.impl.ContactServiceImpl;

public class ContactController extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		Contact contact = new ContactImpl();
		contact.setName(name);
		contact.setEmail(email);
		contact.setMobile(mobile);
		ContactService contactService = new ContactServiceImpl();
		try{
			contact = contactService.save(contact);
		}catch(Exception ex){
			System.out.println("ex");
		}
		response.sendRedirect("list");
	}

}
