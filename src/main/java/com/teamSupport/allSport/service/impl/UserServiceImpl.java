package com.teamSupport.allSport.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamSupport.allSport.dao.UserMapper;
import com.teamSupport.allSport.dto.Meeting;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;
import com.teamSupport.allSport.dto.User;
import com.teamSupport.allSport.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	@Override
	public User getUser(String user_key){
		return userMapper.getUser(user_key);
	}
	
	@Override
    public PagingResult findAllUsers(int page){
		PagingResult result = new PagingResult();
		int totalCount = userMapper.getLast();
		PageMaker pageMaker = result.getPageMaker(totalCount, page);
		List<User> list = userMapper.findAllUsers(pageMaker.getCri().getPageStart(), pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;
	}
	
	@Override
    public User deleteUser(String user_key){
		User user = userMapper.getUser(user_key);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String expiredAt = format1.format(System.currentTimeMillis());
		userMapper.leaveUser(user_key, expiredAt, "LEAVE");
		user.setUser_expiredAt(expiredAt);
		user.setUser_status("LEAVE");
		return user;
	}
	
	@Override
    public User insertUser(String user_key, String user_nickname){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String registeredAt = format1.format(System.currentTimeMillis());
		User user = new User(user_key,user_nickname,"JOIN", registeredAt, null);
		userMapper.insertUser(user_key, user_nickname, "JOIN", null, registeredAt);
		return user;
				
	}
}
