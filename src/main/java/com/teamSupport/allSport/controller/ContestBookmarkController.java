package com.teamSupport.allSport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dto.ContestBookmark;
import com.teamSupport.allSport.dto.Meeting;
import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.service.ContestBookmarkService;
import com.teamSupport.allSport.service.ContestService;

@RestController
public class ContestBookmarkController extends AbstractBaseRestController{
	@Autowired
	ContestBookmarkService contestBookmarkService;

	@RequestMapping(path = "/user/{user_key}/contest-bookmark", method = RequestMethod.GET) //ok
	public @ResponseBody ResponseMessage getContestByUserkey(@PathVariable String user_key, int page) {
		 ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	     message.add("result", contestBookmarkService.findByUserKey(user_key, page));
	     return message;
	}
	
	@RequestMapping(path = "/contest-bookmark/{idContestBookmark}", method = RequestMethod.GET) //ok
	public @ResponseBody ResponseMessage getContestById(@PathVariable int idContestBookmark) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", contestBookmarkService.findByIdContestBookmark(idContestBookmark));
	    return message;
		
	}

	@RequestMapping(path = "/contest-bookmark", method = RequestMethod.POST) //ok
	public @ResponseBody ResponseMessage insertContestBookmark(@RequestParam(value = "user_key") String user_key,
			@RequestParam(value = "idContest") int idContest) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", contestBookmarkService.insertContestBookmark(user_key, idContest));
	    return message;
	}

	@RequestMapping(path = "/contest-bookmark/{idContestBookmark}", method = RequestMethod.DELETE) //ok
	public @ResponseBody ResponseMessage deleteContestBookmark(@PathVariable int idContestBookmark) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", contestBookmarkService.deleteContestBookmark(idContestBookmark));
	    return message;
	}
	
	@RequestMapping(path = "/user/{user_key}/contest-bookmark", method = RequestMethod.DELETE) //ok
	public @ResponseBody ResponseMessage deleteByUserKey(@PathVariable String user_key) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", contestBookmarkService.deleteByUserKey(user_key));
		return message;
	}

}
