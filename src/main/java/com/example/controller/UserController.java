package com.example.controller;


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

import com.example.bean.AppProperties;
import com.example.bean.User;
import com.example.service.UserService;


/**
 * The UserController class is a RESTful web service controller. The
 * <code>@RestController</code> annotation informs Spring that each
 * <code>@RequestMapping</code> method returns a <code>@ResponseBody</code>
 * which, by default, contains a ResponseEntity converted into JSON with an
 * associated HTTP status code. This class is perform crud operations on
 * User entity
 * 
 * @author Tayyba23
 */

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
		
		UserService.getInstance().add(user,this.appProperties.getFormat().toLowerCase());
		newUser.setId(user.getId());
		newUser.setName(user.getName());
		newUser.setAddress(user.getAddress());
		newUser.setCnic(user.getCnic());
		newUser.setMobile(user.getMobile());
		return newUser;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/user")
	@ResponseBody
	public String updateStudentRecord(@RequestBody User user) {
		logger.info("-----Info log----- Request Method : PUT, value:/update/user ");
		return UserService.getInstance().upDateStudent(user,this.appProperties.getFormat().toLowerCase());
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/user/{id}")
	@ResponseBody
	public String deleteStudentRecord(@PathVariable String id) {
		logger.info("-----Info log----- Request Method : DELETE, value:/delete/user/{id} ");
	    return UserService.getInstance().deleteUser(id,this.appProperties.getFormat().toLowerCase());
	}

}
