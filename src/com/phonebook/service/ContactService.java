package com.phonebook.service;

import java.util.List;

import com.phonebook.domain.Contact;
import com.phonebook.domain.impl.ContactImpl;

public interface ContactService {

	Contact save(Contact contact);

	boolean delete(int id);

	Contact update(Contact contact);

	List<ContactImpl> list();

	Contact get(int id);
}
