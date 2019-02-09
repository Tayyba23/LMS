package com.example.controller;

import java.util.List;

import com.example.bean.AppProperties;
import com.example.bean.User;
import com.example.bean.UserRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController

public class UserRetrieverController {
    private final AppProperties appProperties;
    private static final Logger logger = LogManager.getLogger(UserRetrieverController.class);

	 @Autowired
	 public UserRetrieverController(AppProperties appProperties) {
		 this.appProperties=appProperties;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/user/alluser")
	 @ResponseBody
	  public List<User> getAllUsers() {
	    logger.info("-----Info log----- Request Method : GET, value:/user/alluser " );
		System.out.println("Application Properties"+ this.appProperties.getFormat());
	  return UserRegistration.getInstance().getUserRecords();
	  }
}
