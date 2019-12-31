package com.teamSupport.allSport.dao;

import org.apache.ibatis.annotations.Param;

import com.teamSupport.allSport.dto.Meeting;

import java.util.List;

public interface MeetingMapper {
	int getLast();
	int getCountByOption(int idContest, String meet_name, String meet_location, String meet_date);
    List<Meeting> getAllMeeting(int pageStart, int perPageNum);
    List<Meeting> findMeetingByOption(int idContest, String meet_name, String meet_location, String meet_date, int pageStart, int perPageNum);
    Meeting findMeetingByMeetId(int idMeeting);
    void deleteMeeting(int idMeeting);
    void deleteMeetingByIdContest(int idContest);
    void insertMeeting(int idMeeting, int idContest, String meet_name, int meet_nowcount,int meet_maxcount, 
    		String meet_location, String meet_contents, String meet_date);
    

}
