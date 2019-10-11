package com.teamSupport.allSport.Meeting;

import org.apache.ibatis.annotations.Param;

import java.util.List;

interface MeetingMapper {
    List<Meeting> getAllMeeting();
    List<Meeting> findMeetingByGameId(int idContest);
    List<Meeting> findMeetingByMeetId(int idMeeting);
    void makeMeeting(@Param(value = "idMeeting") int idMeeting, @Param(value = "idContest") int idContest,
                     @Param(value = "meet_name") String meet_name, @Param(value = "meet_nowcount") int meet_nowcount,
                     @Param(value = "meet_maxcount") int meet_maxcount, @Param(value = "meet_contents") String location,
                     @Param(value = "meet_contents") String meet_contents);

}
