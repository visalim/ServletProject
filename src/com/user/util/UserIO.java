package com.user.util;
import java.util.List;


import com.user.domain.User;
public class UserIO {
static	User user=new User();
public static User read(){
	user.setId(KeyBoard.readInt("enter user id "));
	user.setName(KeyBoard.readString("enter user name"));
	user.setEmail(KeyBoard.readString("enter user email"));
	user.setPassword(KeyBoard.readString("enter user password"));
	return user;
}
public void display(User user){
	System.out.println("user id:"+user.getId());
	System.out.println("user name"+user.getName());
	System.out.println("user Email"+user.getEmail());
	System.out.println("user Password"+user.getPassword());
	
	
}
public static void display(List<User> users) {
	for (User user: users) {
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
	}
}

}
