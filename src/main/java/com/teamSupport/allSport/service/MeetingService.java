package com.teamSupport.allSport.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.teamSupport.allSport.dto.Meeting;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;

public interface MeetingService {
	public PagingResult getAllMeeting(int page);

	public PagingResult findMeetingByOption(int page, int idContest, String meet_name, String meet_location, String meet_date);

	public Meeting findMeetingByMeetId(int idMeeting);

	public Meeting deleteMeeting(int idMeeting);

	public List<Meeting> deleteMeetingByIdContest(int idContest);

	public Meeting makeMeeting(int idContest, String meet_name, int meet_nowcount, int meet_maxcount, String location,
			String meet_contents, String meet_date);
}
