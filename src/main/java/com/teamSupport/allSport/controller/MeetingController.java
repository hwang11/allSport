package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.MeetingMapper;
import com.teamSupport.allSport.dto.ChatRoom;
import com.teamSupport.allSport.dto.Meeting;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@RestController
public class MeetingController {
	@Autowired
	MeetingMapper meetingMapper;

	@RequestMapping(path = "/meeting", method = RequestMethod.GET)
	public @ResponseBody List<Meeting> getMeetings() {
		List<Meeting> meetingList = meetingMapper.getAllMeeting();

		return meetingList;
	}

	@RequestMapping(path = "/contest/{idContest}/meeting", method = RequestMethod.GET)
	public @ResponseBody List<Meeting> findMeetingByContestId(@PathVariable int idContest) {
		List<Meeting> meetingList = meetingMapper.findMeetingByContestId(idContest);

		return meetingList;
	}
	
	@RequestMapping(path = "/meeting/{idMeeting}", method = RequestMethod.GET)
	public @ResponseBody Meeting findMeetingByMeetId(@PathVariable int idMeeting) {
		Meeting meeting = meetingMapper.findMeetingByMeetId(idMeeting);

		return meeting;
	}
	private int idMeeting;
    private String meet_date;
    private String meet_name;
    private String meet_location;
    private String meet_contents;
    private int meet_nowcount;
    private int meet_maxcount;
	
	@RequestMapping(path = "/meeting", method = RequestMethod.POST)
	public @ResponseBody Meeting insertMeeting(int idContest, String meet_name, int meet_nowcount,
			int meet_maxcount, String meet_location, String meet_contents, String meet_date) {
		int idMeeting = meetingMapper.getLast();
		meetingMapper.makeMeeting(idMeeting+1, idContest, meet_name, meet_nowcount, meet_maxcount, meet_location,
				meet_contents,meet_date);
		Meeting meeting = new Meeting(idMeeting+1, meet_date, meet_name, meet_location, meet_contents, meet_nowcount, meet_maxcount,
				 idContest);
		return meeting;
	}

	@RequestMapping(path = "/meeting/{idMeeting}", method = RequestMethod.DELETE) 
	public @ResponseBody Meeting deleteMeetingByIdMeeting(@PathVariable int idMeeting) {
		Meeting meeting = meetingMapper.findMeetingByMeetId(idMeeting);
		meetingMapper.deleteMeeting(idMeeting);
		return meeting;
	}
	
	@RequestMapping(path = "/contest/{idContest}/meeting", method = RequestMethod.DELETE) 
	public @ResponseBody List<Meeting> deleteMeetingByIdContest(@PathVariable int idContest) {
		List list = meetingMapper.findMeetingByContestId(idContest);
		meetingMapper.deleteMeetingByIdContest(idContest);
		return list;
	}
}
