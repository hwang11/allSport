package com.teamSupport.allSport.MeetBookmark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.MeetBookmark.MeetBookmark;
import com.teamSupport.allSport.MeetBookmark.MeetBookmarkMapper;

@RestController
public class MeetBookmarkController {
	@Autowired
	MeetBookmarkMapper meetBookmarkMapper;
	
   @RequestMapping(path = "/MeetBookmark", method = RequestMethod.GET)
   public @ResponseBody List<MeetBookmark> show() {
       List<MeetBookmark> li = meetBookmarkMapper.findAllMeetBookmark();
       return li;
   }
   
   @RequestMapping(path = "/getMeetByUserkey", method = RequestMethod.GET) 
   public @ResponseBody MeetBookmark getMeetByUserkey(@RequestParam(value = "user_key") String user_key) {
	   MeetBookmark meetBookmark = meetBookmarkMapper.findByUserKey(user_key);
       return meetBookmark;
   }
   
   @RequestMapping(path = "/getMeetById", method = RequestMethod.GET) 
   public @ResponseBody MeetBookmark getMeetById(@RequestParam(value = "idMeetBookmark") int idMeetBookmark) {
	   MeetBookmark meetBookmark = meetBookmarkMapper.findByIdMeetBookmark(idMeetBookmark);
       return meetBookmark;
   }
   
   @RequestMapping(path = "/insertMeetBookmark", method = RequestMethod.POST)
   public @ResponseBody MeetBookmark insertMeetBookmark(
                                        @RequestParam(value = "user_key") String user_key,
                                        @RequestParam(value = "idMeeting") int idMeeting) {
	   int count = meetBookmarkMapper.countMeetBookmark();
       MeetBookmark meetBookmark = new MeetBookmark(count+1,user_key,idMeeting);
       meetBookmarkMapper.insertMeetBookmark(count+1,user_key,idMeeting);
       return meetBookmark;
   }
   
   @RequestMapping(path = "/deleteMeetBookmark", method = RequestMethod.DELETE)
   public @ResponseBody String deleteMeetBookmark(
		   @RequestParam(value = "idMeetBookmark") int idMeetBookmark) {
	   meetBookmarkMapper.deleteMeetBookmark(idMeetBookmark);
	   return "success";
   }
 
}
