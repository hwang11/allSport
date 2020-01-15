package com.teamSupport.allSport.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

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
import com.teamSupport.allSport.service.impl.KakaoAPI;

@RestController
public class UserController extends AbstractBaseRestController{
	@Autowired
	private KakaoAPI kakao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;

	@RequestMapping(path = "/user", method = RequestMethod.GET) 
	public @ResponseBody ResponseMessage getUsers(@RequestParam(value = "page", defaultValue = "1") int page) {
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

	@RequestMapping(path = "/user", method = RequestMethod.POST) //가입 
	public @ResponseBody ResponseMessage insertUser(String user_nickname, HttpSession session) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		String user_key = (String) session.getAttribute("userkey");
		session.setAttribute("login", true);
		message.add("result", userService.insertUser(user_key, user_nickname));
		return message;
	}
	
	@RequestMapping(path = "/user/{user_key}", method = RequestMethod.PATCH)
	public @ResponseBody ResponseMessage leaveUser(@PathVariable String user_key) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", userService.deleteUser(user_key));
		return message;
	}

	@RequestMapping(value="/login")
	public ResponseMessage login(@RequestParam("code") String code, HttpSession session) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		String token[] = kakao.getAccessToken(code); //토큰받기 
		String access_Token = token[0];
		String refresh_Token = token[1];
		System.out.println("controller access_token : " + access_Token);
		
		int id = kakao.getUserKey(access_Token);
		String userkey = Integer.toString(id);
		
		if(userMapper.getUser(userkey) == null) { //회원가입 안된 상태 
			message.add("login", false);
		}else {
			session.setAttribute("login", true);
			session.setMaxInactiveInterval(60*60*24*60); //두달 
		}
		session.setAttribute("userkey", userkey);
		session.setAttribute("access_Token", access_Token);
		session.setAttribute("refresh_Token", refresh_Token);
		return message;
	}
	
	@RequestMapping(value="/logout")
	public void logout(HttpSession session) { //세션에서 정보 없애기 
		kakao.kakaoLogout((String)session.getAttribute("access_Token"));
		session.removeAttribute("access_Token");
		session.removeAttribute("refresh_Token");
		session.removeAttribute("userkey");
		session.removeAttribute("login");
	}
	
}
