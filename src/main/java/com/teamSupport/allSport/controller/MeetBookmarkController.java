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

import com.teamSupport.allSport.dto.MeetBookmark;
import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.service.MeetBookmarkService;

@RestController
public class MeetBookmarkController extends AbstractBaseRestController{
	@Autowired
	MeetBookmarkService meetBookmarkService;
	
   @RequestMapping(path = "/user/{user_key}/meeting-bookmark", method = RequestMethod.GET) 
   public @ResponseBody ResponseMessage getMeetByUserkey(@RequestParam(value = "page", defaultValue = "1")int page, @PathVariable String user_key) {
	   ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	   message.add("result", meetBookmarkService.findByUserKey(page, user_key));
	   return message;

   }
   
   @RequestMapping(path = "/meeting-bookmark/{idMeetBookmark}", method = RequestMethod.GET) 
   public @ResponseBody ResponseMessage getMeetById(@PathVariable int idMeetBookmark) {
	   ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	   message.add("result", meetBookmarkService.findByIdMeetBookmark(idMeetBookmark));
	   return message;
   }
   
   @RequestMapping(path = "/meeting-bookmark", method = RequestMethod.POST)
   public @ResponseBody ResponseMessage insertMeetBookmark(String user_key, int idMeeting) {
	   ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	   message.add("result", meetBookmarkService.insertMeetBookmark(user_key, idMeeting));
	   return message;
   }
   
   @RequestMapping(path = "/meeting-bookmark/{idMeetBookmark}", method = RequestMethod.DELETE)
   public @ResponseBody ResponseMessage deleteMeetBookmark(@PathVariable int idMeetBookmark) {
	   ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	   message.add("result", meetBookmarkService.deleteMeetBookmark(idMeetBookmark));
	   return message;
   }
   
   @RequestMapping(path = "/user/{user_key}/meeting-bookmark", method = RequestMethod.DELETE) 
   public @ResponseBody ResponseMessage deleteMeetByUserkey(@PathVariable String user_key) {
	   ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	   message.add("result", meetBookmarkService.deleteByUserKey(user_key));
	   return message;
   }
 
}
