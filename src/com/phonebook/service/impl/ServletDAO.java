package com.phonebook.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class ServletDAO {
	
	public Connection getConnection(String driverName,String driverUrl,String userName,String password ) throws Exception {
		Class.forName(driverName);
		Connection connection = DriverManager.getConnection(driverUrl,userName,password);
		return connection;
	}

}
