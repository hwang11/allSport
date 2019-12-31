package com.teamSupport.allSport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamSupport.allSport.dao.FollowMapper;
import com.teamSupport.allSport.dto.Follow;

@Service
public class FollowServiceImpl implements FollowService{
	@Autowired
	FollowMapper followMapper;
	
	@Override
	public List<String> getFollowing(String follower_nickname){
		return followMapper.getFollowing(follower_nickname);
	}

	@Override
	public List<String> getFollower(String following_nickname){
		return followMapper.getFollower(following_nickname);
	}
	
	@Override
	public String unfollowing(String following_nickname, String follower_nickname){
		followMapper.unfollowing(following_nickname, follower_nickname);
		return following_nickname;
	}

	@Override
	public Follow addFollow(String following_nickname, String follower_nickname){
		Follow follow = new Follow(following_nickname,follower_nickname);
		followMapper.addFollow(following_nickname, follower_nickname);
		return follow;
	}
	
}
