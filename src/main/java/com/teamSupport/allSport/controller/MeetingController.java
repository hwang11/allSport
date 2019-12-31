package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.MeetingMapper;
import com.teamSupport.allSport.dto.ChatRoom;
import com.teamSupport.allSport.dto.Meeting;
import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.service.MeetingService;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@RestController
public class MeetingController extends AbstractBaseRestController{
	@Autowired
	MeetingService meetingService;

	@RequestMapping(path = "/meeting", method = RequestMethod.GET)
	public @ResponseBody ResponseMessage getMeetings(int page) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", meetingService.getAllMeeting(page));
		return message;
	}
	
	@RequestMapping(path = "/meeting/{idMeeting}", method = RequestMethod.GET)
	public @ResponseBody ResponseMessage findMeetingByMeetId(@PathVariable int idMeeting) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", meetingService.findMeetingByMeetId(idMeeting));
		return message;
	}
	
	@RequestMapping(path = "/meeting", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage insertMeeting(int idContest, String meet_name, 
			int meet_maxcount, String meet_location, String meet_contents, String meet_date) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", meetingService.makeMeeting(idContest, meet_name, 0, 
				meet_maxcount, meet_location, meet_contents, meet_date));
		return message;
	}
	

	@RequestMapping(path = "/meeting/search", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage searchMeeting(int page, 
			@RequestParam(value = "idContest", defaultValue = "0") int idContest, 
			@RequestParam(value = "meet_name", defaultValue = "aa") String meet_name,
			@RequestParam(value = "meet_location", defaultValue = "aa") String meet_location,
			@RequestParam(value = "meet_date", defaultValue = "aa") String meet_date) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", meetingService.findMeetingByOption(page, idContest, meet_name, meet_location,meet_date));
		return message;
	}


	@RequestMapping(path = "/meeting/{idMeeting}", method = RequestMethod.DELETE) 
	public @ResponseBody ResponseMessage deleteMeetingByIdMeeting(@PathVariable int idMeeting) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", meetingService.deleteMeeting(idMeeting));
		return message;
	}
	
	@RequestMapping(path = "/contest/{idContest}/meeting", method = RequestMethod.DELETE) 
	public @ResponseBody ResponseMessage deleteMeetingByIdContest(@PathVariable int idContest) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		message.add("result", meetingService.deleteMeetingByIdContest(idContest));
		return message;
	}
}
