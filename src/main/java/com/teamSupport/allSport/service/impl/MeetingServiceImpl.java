package com.teamSupport.allSport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamSupport.allSport.mapper.MeetingMapper;
import com.teamSupport.allSport.dto.Meeting;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;
import com.teamSupport.allSport.service.MeetingService;

@Service
public class MeetingServiceImpl implements MeetingService {
	@Autowired
	MeetingMapper meetingMapper;

	@Override
	public PagingResult getAllMeeting(int page){
		PagingResult result = new PagingResult();
		int totalCount = meetingMapper.getLast();
		PageMaker pageMaker = result.getPageMaker(totalCount, page);
		List<Meeting> list = meetingMapper.getAllMeeting(pageMaker.getCri().getPageStart(), pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;
	}
	@Override
	public PagingResult findMeetingByOption(int page, int idContest, String meet_name, String meet_location,String meet_date){
		PagingResult result = new PagingResult();
		int totalCount = meetingMapper.getCountByOption(idContest, meet_name, meet_location, meet_date);
		PageMaker pageMaker = result.getPageMaker(totalCount, page);
		List<Meeting> list = meetingMapper.findMeetingByOption(idContest, meet_name, meet_location,meet_date, pageMaker.getCri().getPageStart(), pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;
	}

	@Override
	public Meeting findMeetingByMeetId(int idMeeting){
		return meetingMapper.findMeetingByMeetId(idMeeting);
	}

	@Override
	public Meeting deleteMeeting(int idMeeting){
		Meeting meeting = meetingMapper.findMeetingByMeetId(idMeeting);
		meetingMapper.deleteMeeting(idMeeting);
		return meeting;
	}
	
	@Override
	public List<Meeting> deleteMeetingByIdContest(int idContest){
		List<Meeting> list = meetingMapper.findMeetingByOption(idContest, "aa", "aa", "aa", 0, 0);
		meetingMapper.deleteMeetingByIdContest(idContest);
		return list;
	}

	@Override
	public Meeting makeMeeting(int idContest, String meet_name, int meet_nowcount, int meet_maxcount, String meet_location,
			String meet_contents, String meet_date){
		int id = meetingMapper.getLast();
		meetingMapper.insertMeeting(id+1,idContest, meet_name, meet_nowcount, meet_maxcount, meet_location, meet_contents, meet_date);
		Meeting meeting = new Meeting(idContest,meet_date,meet_name,meet_location,meet_contents,meet_nowcount,meet_maxcount,id+1);
		return meeting;
	}
}
