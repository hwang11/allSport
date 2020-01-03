package com.teamSupport.allSport.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.teamSupport.allSport.dto.PagingResult;
import com.teamSupport.allSport.dto.User;

public interface UserService {
	public User getUser(String user_key);
    public PagingResult findAllUsers(int page);
    public User deleteUser(String user_key);
    public User insertUser(String user_key, String user_nickname);
}
