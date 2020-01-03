package com.teamSupport.allSport.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamSupport.allSport.dao.UserMapper;
import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.service.UserService;
import com.teamSupport.allSport.service.impl.KakaoAPI;

@Controller
public class HomeController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	

}
