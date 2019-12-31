package com.teamSupport.allSport.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.teamSupport.allSport.dto.User;

import java.util.List;

@Mapper
@Repository
public
interface UserMapper {
	int getLast();
	User getUser(String user_key);
    List<User> findAllUsers(int pageStart, int perPageNum);
    void leaveUser(String user_key, String expiredAt, String status);
    void insertUser(@Param(value = "user_key") String user_key, 
    		@Param(value = "user_nickname") String user_nickname,
    		@Param(value = "status") String status,
    		@Param(value = "token") String token,
    		@Param(value = "expiredAt") String expiredAt,
    		@Param(value = "registeredAt") String registeredAt);
}
