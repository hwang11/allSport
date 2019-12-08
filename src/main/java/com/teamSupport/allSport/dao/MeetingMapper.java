package com.teamSupport.allSport.dao;

import org.apache.ibatis.annotations.Param;

import com.teamSupport.allSport.dto.Meeting;

import java.util.List;

public interface MeetingMapper {
	int getLast();
    List<Meeting> getAllMeeting();
    List<Meeting> findMeetingByContestId(int idContest);
    Meeting findMeetingByMeetId(int idMeeting);
    void deleteMeeting(int idMeeting);
    void deleteMeetingByIdContest(int idContest);
    void makeMeeting(@Param(value = "idMeeting") int idMeeting, @Param(value = "idContest") int idContest,
                     @Param(value = "meet_name") String meet_name, @Param(value = "meet_nowcount") int meet_nowcount,
                     @Param(value = "meet_maxcount") int meet_maxcount, @Param(value = "meet_location") String location,
                     @Param(value = "meet_contents") String meet_contents,  @Param(value = "meet_date") String meet_date);
    

}
