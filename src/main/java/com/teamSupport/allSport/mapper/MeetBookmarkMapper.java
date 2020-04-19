package com.teamSupport.allSport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.teamSupport.allSport.dto.MeetBookmark;

@Mapper
@Repository
public interface MeetBookmarkMapper {
	List<MeetBookmark> findAllMeetBookmark();
	List<MeetBookmark> findByUserKey(String user_key, int pageStart, int perPageNum);
	MeetBookmark findByIdMeetBookmark(int idMeetBookmark);
	int getLast();
	void insertMeetBookmark(int idMeetBookmark, String user_key, int idMeeting);
	void deleteMeetBookmark(int idMeetBookmark);
	void deleteByUserKey(String user_key);
}
