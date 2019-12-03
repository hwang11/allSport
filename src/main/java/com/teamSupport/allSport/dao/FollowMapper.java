package com.teamSupport.allSport.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowMapper {
    public List<String> getFollowing(String follower_nickname);
    public List<String> getFollower(String following_nickname);
    public void unfollowing(@Param(value = "following_nickname") String following_nickname, 
    		@Param(value = "follower_nickname") String follower_nickname);
    public void addFollow(@Param(value = "following_nickname") String following_nickname, 
    		@Param(value = "follower_nickname") String follower_nickname);
    public String Follow(@Param(value = "following_nickname") String following_nickname, 
    		@Param(value = "follower_nickname") String follower_nickname);
}
