package com.teamSupport.allSport.Meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MeetingController {
    @Autowired
    MeetingMapper meetingMapper;

    @RequestMapping(path = "/meeting", method = RequestMethod.GET)
    public @ResponseBody List<Meeting> getAllMeeting() {
        List<Meeting> meetingList = meetingMapper.getAllMeeting();

        return meetingList;
    }

    @RequestMapping(path = "/meeting/idContest", method = RequestMethod.GET)
    public @ResponseBody List<Meeting> findMeetingByContestId(int idContest) {
        List<Meeting> meetingList = meetingMapper.findMeetingByGameId(idContest);

        return meetingList;
    }

    @RequestMapping(path = "/meeting/idMeeting", method = RequestMethod.GET)
    public @ResponseBody List<Meeting> findMeetingByMeetId(int idMeeting) {
        List<Meeting> meetingList = meetingMapper.findMeetingByMeetId(idMeeting);

        return  meetingList;
    }

    @RequestMapping(path = "/makeMeeting", method = RequestMethod.POST)
    public @ResponseBody void makeMeeting(int idMeeting, int idContest, String meet_name,
                                           int meet_nowcount, int meet_maxcount, String meet_location,
                                           String meet_contents) {
        meetingMapper.makeMeeting(idMeeting, idContest, meet_name, meet_nowcount, meet_maxcount, meet_location, meet_contents);

    }

}
