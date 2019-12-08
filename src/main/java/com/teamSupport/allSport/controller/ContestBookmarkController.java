package com.teamSupport.allSport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.ContestBookmarkMapper;
import com.teamSupport.allSport.dao.ContestMapper;
import com.teamSupport.allSport.dto.ContestBookmark;
import com.teamSupport.allSport.dto.Meeting;

@RestController
public class ContestBookmarkController {
	@Autowired
	ContestBookmarkMapper contestBookmarkMapper;

	@RequestMapping(path = "/contest-bookmark", method = RequestMethod.GET) 
	public @ResponseBody List<ContestBookmark> show() {
		List<ContestBookmark> li = contestBookmarkMapper.findAllContestBookmark();
		return li;
	}

	@RequestMapping(path = "/user/{user_key}/contest-bookmark", method = RequestMethod.GET)
	public @ResponseBody List<ContestBookmark> getContestByUserkey(@PathVariable String user_key) {
		List<ContestBookmark> li  = contestBookmarkMapper.findByUserKey(user_key);
		return li;
	}
	
	@RequestMapping(path = "/contest-bookmark/{idContestBookmark}", method = RequestMethod.GET) 
	public @ResponseBody ContestBookmark getContestById(@PathVariable int idContestBookmark) {
		ContestBookmark contestBookmark = contestBookmarkMapper.findByIdContestBookmark(idContestBookmark);
		return contestBookmark;
	}

	@RequestMapping(path = "/contest-bookmark", method = RequestMethod.POST) 
	public @ResponseBody ContestBookmark insertContestBookmark(@RequestParam(value = "user_key") String user_key,
			@RequestParam(value = "idContest") int idContest) {
		int bookmarkId = contestBookmarkMapper.getLast();
		ContestBookmark contestBookmark = new ContestBookmark(bookmarkId + 1, user_key, idContest);
		contestBookmarkMapper.insertContestBookmark(bookmarkId + 1, user_key, idContest);
		return contestBookmark;
	}

	@RequestMapping(path = "/contest-bookmark/{idContestBookmark}", method = RequestMethod.DELETE) 
	public @ResponseBody ContestBookmark deleteContestBookmark(@PathVariable int idContestBookmark) {
		ContestBookmark bookmark = contestBookmarkMapper.findByIdContestBookmark(idContestBookmark);
		contestBookmarkMapper.deleteContestBookmark(idContestBookmark);
		return bookmark;
	}
	
	@RequestMapping(path = "/user/{user_key}/contest-bookmark", method = RequestMethod.DELETE) 
	public @ResponseBody List<ContestBookmark> deleteByUserKey(@PathVariable String user_key) {
		List list = contestBookmarkMapper.findByUserKey(user_key);
		
		contestBookmarkMapper.deleteByUserKey(user_key);
		return list;
	}

}
