package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Tayyba23
 * 
 *         Business service class to perform operation on User entity
 *
 */

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

	public void add(User user,String format) {
	
		try {

			/**
			 * As a part of improvement, we can add the implementation of adding multiple
			 * json objects in file, currently it is over writing in file
			 **/
			
		if (format.equals("json")) {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("user.json");
			ArrayNode outerArray = null;

			outerArray = mapper.createArrayNode(); // your outer array
			ObjectNode outerObject = mapper.createObjectNode(); // the object with the "data" array
			outerObject.pojoNode(user);

			outerArray.add(outerObject);
			System.out.println(outerArray.toString()); // just to confirm everything is working
			// Serialize Java object info JSON file.
			mapper.writeValue(file, user);
			
		} else {

			Yaml yaml = new Yaml();
			FileWriter writer = new FileWriter("user.yaml");
			yaml.dump(user, writer);
		}

	} catch (IOException e) {
		e.printStackTrace();
	}
		userRecords.add(user);
	}

	public List<User> getUserRecords() {
		return userRecords;
	}

	public String upDateStudent(User user,String format) {
		for (int i = 0; i < userRecords.size(); i++) {
			User userRec = userRecords.get(i);
			if (userRec.getId().equals(user.getId())) {
				userRecords.set(i, user);// update the new record
				return "User Updated successful";
			}
		}
		return "User Update un-successful";
	}
	
	public String deleteUser(String id,String format) {
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
