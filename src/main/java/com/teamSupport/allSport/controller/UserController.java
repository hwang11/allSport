package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.UserMapper;
import com.teamSupport.allSport.dto.User;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class UserController {

	@Autowired
	UserMapper userMapper;

	@RequestMapping(path = "/user", method = RequestMethod.GET) 
	public @ResponseBody List<User> getUsers() {
		List<User> user = userMapper.findAllUsers();
		return user;
	}

	@RequestMapping(path = "/user/{user_key}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable String user_key) {
		User user = userMapper.getUser(user_key);

		return user;
	}

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public @ResponseBody User insertUser(String user_key, String user_nickname, 
			String token) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String registeredAt = format1.format(System.currentTimeMillis());
		String status = "JOIN";
		User user = new User(user_key, user_nickname, status, token, registeredAt, null);
		userMapper.insertUser(user_key, user_nickname, status, token, registeredAt, null);
		return user;
	}
	
	@RequestMapping(path = "/user/{user_key}", method = RequestMethod.PATCH)
	public @ResponseBody User leaveUser(@PathVariable String user_key) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String expiredAt = format1.format(System.currentTimeMillis());
		String status = "LEAVE";
		userMapper.leaveUser(user_key,expiredAt,status);
		User user = userMapper.getUser(user_key);
		return user;
	}

	
}
