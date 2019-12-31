package com.teamSupport.allSport.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.teamSupport.allSport.dto.MeetBookmark;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;

public interface MeetBookmarkService {
	public PagingResult findByUserKey(int page, String user_key);
	public MeetBookmark findByIdMeetBookmark(int idMeetBookmark);
	public MeetBookmark insertMeetBookmark(String user_key, int idMeeting);
	public MeetBookmark deleteMeetBookmark(int idMeetBookmark);
	public List<MeetBookmark> deleteByUserKey(String user_key);
}
