package com.phonebook.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.phonebook.domain.Contact;
import com.phonebook.domain.impl.ContactImpl;
import com.phonebook.service.ContactService;
import com.phonebook.service.PhoneBookConstant;

public class ContactServiceImpl implements ContactService {

	Connection connection = null;
	ServletDAO dao = new ServletDAO();

	public Contact save(Contact contact) throws Exception {
		connection = dao.getConnection(PhoneBookConstant.DRIVER_NAME, PhoneBookConstant.DRIVER_URL,
				PhoneBookConstant.USER_NAME, PhoneBookConstant.PASSWORD);
		try {
			String sql = "insert into contact(id,name,email,mobile) values(?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, contact.getId());
			pstmt.setString(2, contact.getName());
			pstmt.setString(3, contact.getEmail());
			pstmt.setString(4, contact.getMobile());
			pstmt.executeUpdate();
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				contact.setId(generatedKeys.getInt(1));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			connection.close();
		}
		return contact;
	}

	public boolean delete(int id) throws Exception {
		connection = dao.getConnection(PhoneBookConstant.DRIVER_NAME, PhoneBookConstant.DRIVER_URL,
				PhoneBookConstant.USER_NAME, PhoneBookConstant.PASSWORD);
		boolean isdeleted = false;
		try {
			String sql = "delete from contact where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			int d = pstmt.executeUpdate();
			if (d == 1) {
				isdeleted = true;
			}

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			connection.close();
		}
		return isdeleted;
	}

	public Contact update(Contact contact) throws Exception {
		connection = dao.getConnection(PhoneBookConstant.DRIVER_NAME, PhoneBookConstant.DRIVER_URL,
				PhoneBookConstant.USER_NAME, PhoneBookConstant.PASSWORD);
		try {
			String sql = "update  contact set name=?,email=?,mobile=? where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getEmail());
			pstmt.setString(3, contact.getMobile());
			pstmt.setInt(4, contact.getId());
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			connection.close();
		}
		return contact;
	}

	public List<ContactImpl> list() throws Exception {
		List<ContactImpl> contacts = new ArrayList<ContactImpl>();
		connection = dao.getConnection(PhoneBookConstant.DRIVER_NAME, PhoneBookConstant.DRIVER_URL,
				PhoneBookConstant.USER_NAME, PhoneBookConstant.PASSWORD);
		try {
			PreparedStatement pstmt = null;
			String sql = "select * from contact";
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ContactImpl contact = new ContactImpl();
				contact.setId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				contact.setMobile(rs.getString(4));
				contacts.add(contact);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			connection.close();
		}
		return contacts;
	}

	public Contact get(int id) throws Exception {
		connection = dao.getConnection(PhoneBookConstant.DRIVER_NAME, PhoneBookConstant.DRIVER_URL,
				PhoneBookConstant.USER_NAME, PhoneBookConstant.PASSWORD);
		Contact contact = null;
		try {
			PreparedStatement pstmt = null;
			String sql = "select id,name,email,mobile  from contact where id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				contact = new ContactImpl();
				contact.setId(id);
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				contact.setMobile(rs.getString(4));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			connection.close();
		}
		return contact;
	}

}
