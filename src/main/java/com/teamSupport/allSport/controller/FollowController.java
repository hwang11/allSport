package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.FollowMapper;
import com.teamSupport.allSport.dto.Follow;

import java.util.List;

@RestController
public class FollowController {
	@Autowired
	private FollowMapper followMapper;

	// /following/a => a가 follow하는 사람 목록
	@RequestMapping(path = "/following/{follower_nickname}", method = RequestMethod.GET)
	public @ResponseBody List<String> getFollowing(@PathVariable String follower_nickname) {
		List<String> followList = followMapper.getFollowing(follower_nickname);

		return followList;
	}

	// /follower/a => a를 follow하는 사람 목록
	@RequestMapping(path = "/follower/{following_nickname}", method = RequestMethod.GET)
	public @ResponseBody List<String> getFollower(@PathVariable String following_nickname) {
		List<String> followList = followMapper.getFollower(following_nickname);

		return followList;
	}

	@RequestMapping(path = "/follow", method = RequestMethod.POST)
	public @ResponseBody Follow insertFollow(String following_nickname, String follower_nickname) {
		Follow follow = new Follow(following_nickname, follower_nickname);
		followMapper.addFollow(following_nickname, follower_nickname);
		return follow;
	}

	// a가 follow하는 사람 목록 중에서 b삭제 follower_nickname=a, following_nickname=b
	@RequestMapping(path = "/follow", method = RequestMethod.DELETE)
	public @ResponseBody String deleteFollow(@RequestParam String follower_nickname, @RequestParam String following_nickname) {
		following_nickname = followMapper.Follow(following_nickname, follower_nickname);
		followMapper.unfollowing(following_nickname, follower_nickname);
		return following_nickname;
	}
}
