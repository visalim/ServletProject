package com.phonebook.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.phonebook.domain.Contact;
import com.phonebook.service.ContactService;

public class ContactServiceImpl implements ContactService{
	public Connection getConnection() throws Exception {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		return connection;
	}

	public Contact save(Contact contact) {
		try {
			Connection connection = getConnection();
			String sql = "insert into contact(id,name,email,mobile) values('?,?,?,?')";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			pstmt.setInt(1, contact.getId());
			pstmt.setString(2, contact.getName());
			pstmt.setString(3, contact.getEmail());
			pstmt.setString(4, contact.getMobile());
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				contact.setId(generatedKeys.getInt(1));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return contact;
	}

	public boolean delete(int id) {
		boolean isdeleted = false;
		try {
			Connection connection = getConnection();
			String sql = "delete name,email,mobile from contact where id=?";
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

	public Contact update(Contact contact) {
		try {
			Connection connection = getConnection();
			String sql = "update into contact set name=?,email=?,mobile=? where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getEmail());
			pstmt.setString(3, contact.getMobile());
			pstmt.setInt(4, contact.getId());

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return contact;
	}

	public List<Contact> list() {
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = null;
			String sql = "select * from customer";
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				contact.setMobile(rs.getString(4));
				contacts.add(contact);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return contacts;
	}

	public Contact get(int id) {
		Contact contact = null;
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = null;
			String sql = "select id,name,email,mobile  from contact where id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				contact = new Contact();
				contact.setId(id);
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				contact.setMobile(rs.getString(4));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return contact;
	}

}
