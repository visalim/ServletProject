package com.phonebook.service;

import java.util.List;
import com.phonebook.service.UserService;

import com.phonebook.domain.impl.UserImpl;
import com.phonebook.domain.User;

public interface UserService {
	User save(User user);

	boolean delete(int id);

	User update(User user);

	List<User> list();

	User get(int id);
	
	User findByEmailAndPassword(String Email,String Password);
	
	User findByEmail(String Email);

}
