package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.UserMapper;
import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.dto.User;
import com.teamSupport.allSport.service.UserService;

@RestController
public class UserController extends AbstractBaseRestController{

	@Autowired
	UserService userService;

	@RequestMapping(path = "/user", method = RequestMethod.GET) 
	public @ResponseBody ResponseMessage getUsers(int page) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", userService.findAllUsers(page));
		return message;
	}

	@RequestMapping(path = "/user/{user_key}", method = RequestMethod.GET)
	public @ResponseBody ResponseMessage getUser(@PathVariable String user_key) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", userService.getUser(user_key));
		return message;
	}

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage insertUser(String user_key, String user_nickname, 
			String token) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", userService.insertUser(user_key, user_nickname, token));
		return message;
	}
	
	@RequestMapping(path = "/user/{user_key}", method = RequestMethod.PATCH)
	public @ResponseBody ResponseMessage leaveUser(@PathVariable String user_key) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", userService.deleteUser(user_key));
		return message;
	}

	
}
