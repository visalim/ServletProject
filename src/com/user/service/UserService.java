package com.user.service;
import java.util.List;
public interface UserService {
	 User save(User user);
	 boolean delete(int id);
	 User update(User user);
	 List<User> list();
	 User get(int id);


}
