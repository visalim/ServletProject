package com.phonebook.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.phonebook.domain.User;
import com.phonebook.service.UserService;

public class UserServiceImpl implements UserService {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		return connection;
	}

	public User save(User user) {
		try {
			Connection connection = getConnection();
			String sql = "insert into phonebook(id,name,email,password)values('?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				user.setId(generatedKeys.getInt(1));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return user;
	}

	public boolean delete(int id) {
		boolean isdeleted = false;
		try {
			Connection connection = getConnection();
			String sql = "delete from phonebook where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			int d = pstmt.executeUpdate();
			if (d == 1) {
				isdeleted = true;

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return isdeleted;
	}

	public User update(User user) {
		try {
			Connection connection = getConnection();
			String sql = "update phonebook set name=?,email=?,password=? where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(1, user.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return user;
	}

	public List<User> list() {
		List<User> Users = new ArrayList<User>();
		try {
			Connection connection = getConnection();
			String sql = "select id,name,email,password from phonebook";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				Users.add(user);

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return Users;
	}

	public User get(int id) {
		User user = null;
		try {
			Connection connection = getConnection();
			String sql = "select name,email,password from phonebook where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setName(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setId(id);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return user;
	}
}