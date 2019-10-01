package com.teamSupport.allSport.Follow;

import org.apache.ibatis.annotations.Param;

import java.util.List;

interface FollowMapper {
    public List<Follow> getFollowing(String follower_nickname);
    public List<Follow> getFollwer(String following_nickname);
    public void addFollow(@Param(value = "following_nickname") String following_nickname, @Param(value = "follower_nickname") String follower_nickname);
}
