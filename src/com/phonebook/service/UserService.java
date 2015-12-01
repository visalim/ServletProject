package com.phonebook.service;

import java.util.List;
import com.phonebook.service.UserService;
import com.phonebook.domain.User;

public interface UserService {
	
	User save(User user) throws Exception;

	boolean delete(int id) throws Exception;

	User update(User user) throws Exception;

	List<User> list() throws Exception;

	User get(int id) throws Exception;

	User findByEmailAndPassword(String Email, String Password) throws Exception;

	User findByEmail(String Email) throws Exception;

}
