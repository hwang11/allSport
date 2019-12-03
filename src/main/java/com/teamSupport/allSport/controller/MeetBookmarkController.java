package com.teamSupport.allSport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.MeetBookmarkMapper;
import com.teamSupport.allSport.dto.MeetBookmark;

@RestController
public class MeetBookmarkController {
	@Autowired
	MeetBookmarkMapper meetBookmarkMapper;
	
   @RequestMapping(path = "/user/{user_key}/meeting-bookmark", method = RequestMethod.GET) 
   public @ResponseBody List<MeetBookmark> getMeetByUserkey(@PathVariable String user_key) {
	   List<MeetBookmark> li = meetBookmarkMapper.findByUserKey(user_key);
       return li;
   }
   
   @RequestMapping(path = "/meeting-bookmark/{idMeetBookmark}", method = RequestMethod.GET) 
   public @ResponseBody MeetBookmark getMeetById(@PathVariable int idMeetBookmark) {
	   MeetBookmark meetBookmark = meetBookmarkMapper.findByIdMeetBookmark(idMeetBookmark);
       return meetBookmark;
   }
   
   @RequestMapping(path = "/meeting-bookmark", method = RequestMethod.POST)
   public @ResponseBody MeetBookmark insertMeetBookmark(@RequestParam(value = "user_key") String user_key,
                                        @RequestParam(value = "idMeeting") int idMeeting) {
	   int idMeetBookmark = meetBookmarkMapper.getLast();
       MeetBookmark meetBookmark = new MeetBookmark(idMeetBookmark+1,user_key,idMeeting);
       meetBookmarkMapper.insertMeetBookmark(idMeetBookmark+1,user_key,idMeeting);
       return meetBookmark;
   }
   
   @RequestMapping(path = "/meeting-bookmark/{idMeetBookmark}", method = RequestMethod.DELETE)
   public @ResponseBody MeetBookmark deleteMeetBookmark(@PathVariable int idMeetBookmark) {
	   MeetBookmark bookmark = meetBookmarkMapper.findByIdMeetBookmark(idMeetBookmark);
	   meetBookmarkMapper.deleteMeetBookmark(idMeetBookmark);
	   return bookmark;
   }
   
   @RequestMapping(path = "/user/{user_key}/meeting-bookmark", method = RequestMethod.DELETE) 
   public @ResponseBody List<MeetBookmark> deleteMeetByUserkey(@PathVariable String user_key) {
	   List<MeetBookmark> li = meetBookmarkMapper.findByUserKey(user_key);
	   meetBookmarkMapper.deleteByUserKey(user_key);
       return li;
   }
 
}
