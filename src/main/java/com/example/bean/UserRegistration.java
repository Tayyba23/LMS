package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class UserRegistration {
	private List<User> userRecords;
	private static UserRegistration userReg = null;

	private UserRegistration() {
		userRecords = new ArrayList<User>();
	}

	public static UserRegistration getInstance() {
		if (userReg == null) {
			userReg = new UserRegistration();
			return userReg;
		} else {
			return userReg;
		}
	}

	public void add(User user) {
		userRecords.add(user);
	}

	public List<User> getUserRecords() {
		return userRecords;
	}

}
