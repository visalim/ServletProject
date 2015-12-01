package com.phonebook.service;

import java.util.List;
import com.phonebook.domain.Contact;
import com.phonebook.domain.impl.ContactImpl;

public interface ContactService {

	Contact save(Contact contact) throws Exception;

	boolean delete(int id) throws Exception;

	Contact update(Contact contact) throws Exception;

	List<ContactImpl> list() throws Exception;

	Contact get(int id) throws Exception;

}
