package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.FollowMapper;
import com.teamSupport.allSport.dto.Follow;
import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.service.FollowService;
import java.util.List;

@RestController
public class FollowController extends AbstractBaseRestController{
	@Autowired
	FollowService followService;

	// /following/a => a가 follow하는 사람 목록
	@RequestMapping(path = "/following/{follower_nickname}", method = RequestMethod.GET)
	public @ResponseBody ResponseMessage getFollowing( @PathVariable String follower_nickname) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", followService.getFollowing(follower_nickname));
	    return message;
	}

	// /follower/a => a를 follow하는 사람 목록
	@RequestMapping(path = "/follower/{following_nickname}", method = RequestMethod.GET)
	public @ResponseBody ResponseMessage getFollower( @PathVariable String following_nickname) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", followService.getFollower(following_nickname));
	    return message;
	}

	//follower -> following 
	@RequestMapping(path = "/follow", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage insertFollow( String following_nickname, String follower_nickname) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", followService.addFollow(following_nickname, follower_nickname));
	    return message;
	}

	// a가 follow하는 사람 목록 중에서 b삭제 follower_nickname=a, following_nickname=b
	@RequestMapping(path = "/follow", method = RequestMethod.DELETE)
	public @ResponseBody ResponseMessage deleteFollow(String follower_nickname, String following_nickname) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", followService.unfollowing(following_nickname, follower_nickname));
	    return message;
	}
}
