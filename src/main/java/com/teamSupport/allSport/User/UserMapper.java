package com.teamSupport.allSport.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public
interface UserMapper {

	User getUser(String user_key);
    List<User> findAllUsers();
    void insertUser(@Param(value = "user_key") String user_key, @Param(value = "nickname") String nickname);
}
