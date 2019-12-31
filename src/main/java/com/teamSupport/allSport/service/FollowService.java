package com.teamSupport.allSport.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.teamSupport.allSport.dto.Follow;

public interface FollowService {
	public List<String> getFollowing(String follower_nickname);

	public List<String> getFollower(String following_nickname);

	public String unfollowing(String following_nickname, String follower_nickname);

	public Follow addFollow(String following_nickname, String follower_nickname);
}
