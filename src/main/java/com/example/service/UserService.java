package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.User;

public class UserService {
	private List<User> userRecords;
	private static UserService userReg = null;

	private UserService() {
		userRecords = new ArrayList<User>();
	}

	public static UserService getInstance() {
		if (userReg == null) {
			userReg = new UserService();
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

	public String upDateStudent(User user) {
		for (int i = 0; i < userRecords.size(); i++) {
			User userRec = userRecords.get(i);
			if (userRec.getId().equals(user.getId())) {
				userRecords.set(i, user);// update the new record
				return "User Updated successful";
			}
		}
		return "User Update un-successful";
	}
	
	public String deleteUser(String id) {
		for(int i=0; i<userRecords.size(); i++)
		        {
		            User userRec = userRecords.get(i);
		            if(userRec.getId().equals(id)){
		            	userRecords.remove(i);//update the new record
		              return "User Deleted successfully";
		            }
		        }
		return "User Delete un-successful";
		}

}
