package com.phonebook.service;
import java.util.List;

import com.phonebook.domain.User;
public interface UserService {
	 User save(User user);
	 boolean delete(int id);
	 User update(User user);
	 List<User> list();
	 User get(int id);


}
