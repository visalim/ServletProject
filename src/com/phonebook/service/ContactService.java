package com.phonebook.service;

import java.util.List;

import com.phonebook.domain.Contact;

public interface ContactService {
	
	Contact save(Contact contact);

	boolean delete(int id);

	Contact update(Contact contact);

	List<Contact> list();

	Contact get(int id);

}
