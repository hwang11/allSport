package com.teamSupport.allSport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamSupport.allSport.dao.MeetBookmarkMapper;
import com.teamSupport.allSport.dto.Criteria;
import com.teamSupport.allSport.dto.MeetBookmark;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;
import com.teamSupport.allSport.service.MeetBookmarkService;

@Service
public class MeetBookmarkServiceImpl implements MeetBookmarkService{
	@Autowired
	MeetBookmarkMapper meetBookmarkMapper;
	
	@Override
	public PagingResult findByUserKey(int page, String user_key){
		PagingResult result = new PagingResult();
		int totalCount = meetBookmarkMapper.getLast();
		PageMaker pageMaker = result.getPageMaker(totalCount, page);
		List<MeetBookmark> list 
		= meetBookmarkMapper.findByUserKey(user_key, pageMaker.getCri().getPageStart(), pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;
	}
	public MeetBookmark findByIdMeetBookmark(int idMeetBookmark){
		return meetBookmarkMapper.findByIdMeetBookmark(idMeetBookmark);
	}
	public MeetBookmark insertMeetBookmark(String user_key, int idMeeting){
		int id = meetBookmarkMapper.getLast();
	       MeetBookmark meetBookmark = new MeetBookmark(id+1,user_key,idMeeting);
		meetBookmarkMapper.insertMeetBookmark(id+1, user_key, idMeeting);
		return meetBookmark;
	}
	public MeetBookmark deleteMeetBookmark(int idMeetBookmark){
		MeetBookmark bookmark = meetBookmarkMapper.findByIdMeetBookmark(idMeetBookmark);
		meetBookmarkMapper.deleteMeetBookmark(idMeetBookmark);
		return bookmark;
	}
	public List<MeetBookmark> deleteByUserKey(String user_key){
		int count = meetBookmarkMapper.getLast();
		List<MeetBookmark> li = meetBookmarkMapper.findByUserKey(user_key, 0, count);
		meetBookmarkMapper.deleteByUserKey(user_key);
		return li;
	}
}
