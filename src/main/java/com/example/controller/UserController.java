package com.example.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.Yaml;

import com.example.bean.AppProperties;
import com.example.bean.User;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController

public class UserController {
	private final AppProperties appProperties;
	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	public UserController(AppProperties appProperties) {
		this.appProperties = appProperties;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/alluser")
	@ResponseBody
	public List<User> getAllUsers() {
		return UserService.getInstance().getUserRecords();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user")
	@ResponseBody
	public User registerUser(@RequestBody User user) {
		logger.info("Application Properties - File Format " + this.appProperties.getFormat());
		logger.info("-----Info log----- Request Method : POST, value:/user ");
		User newUser = new User();
		/**
		 * As a part of improvement, we can add the implementation of adding multiple
		 * json objects in file, currently it is over writing
		 **/

		try {

			if (this.appProperties.getFormat().toLowerCase().equals("json")) {

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
				UserService.getInstance().add(user);

				// setting the below value just to reply a message back to the caller
				newUser.setName(user.getName());
				newUser.setAddress(user.getAddress());
				newUser.setCnic(user.getCnic());
				newUser.setMobile(user.getMobile());
			} else {

				Yaml yaml = new Yaml();
				FileWriter writer = new FileWriter("user.yaml");
				yaml.dump(user, writer);
				UserService.getInstance().add(user);

				// setting the below value just to reply a message back to the caller
				newUser.setName(user.getName());
				newUser.setAddress(user.getAddress());
				newUser.setCnic(user.getCnic());
				newUser.setMobile(user.getMobile());
				newUser.setId(user.getId());

				logger.info("-----Info log----- Request Method : POST, value:/user, user Added ");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return newUser;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/user")
	@ResponseBody
	public String updateStudentRecord(@RequestBody User user) {
		logger.info("-----Info log----- Request Method : PUT, value:/update/user ");
		return UserService.getInstance().upDateStudent(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/user/{id}")
	@ResponseBody
	public String deleteStudentRecord(@PathVariable String id) {
		logger.info("-----Info log----- Request Method : DELETE, value:/delete/user/{id} ");
	    return UserService.getInstance().deleteUser(id);
	}

}
