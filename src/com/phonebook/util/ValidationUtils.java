package com.phonebook.util;

import java.util.HashMap;
import java.util.Map;

import com.phonebook.domain.Contact;

public class ValidationUtils {

	static Map<String, Object> fieldErrors;

	public static Map<String, Object> validate(Contact contact) {
		fieldErrors = new HashMap<String, Object>();
		fieldErrors.put("hasErrors", false);
		
		if (!isValid(contact.getName())) {
			fieldErrors.put("name", "Name can not be empty");
			fieldErrors.put("hasErrors", true);
		} else if (!isInRange(contact.getName())) {
			fieldErrors.put("name", "Name should be in between 5 to 10 characters");
			fieldErrors.put("hasErrors", true);
		}


		if (!isValid(contact.getEmail())) {
			fieldErrors.put("email", "Please enter a valid email");
			fieldErrors.put("hasErrors", true);
		}

		if (!isValid(contact.getMobile())) {
			fieldErrors.put("mobile", "Please enter a valid mobile number");
			fieldErrors.put("hasErrors", true);
		}

		return fieldErrors;
	}

	private static boolean isValid(String text) {
		return (text.trim().length() != 0);
	}
	
	private static boolean isInRange(String text) {
		text = text.trim();
		return (text.length() >= 5 && text.length() <= 10);
	}

}
