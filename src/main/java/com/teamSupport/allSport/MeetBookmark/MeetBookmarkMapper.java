package com.teamSupport.allSport.MeetBookmark;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.teamSupport.allSport.MeetBookmark.MeetBookmark;

@Mapper
@Repository
public interface MeetBookmarkMapper {
	List<MeetBookmark> findAllMeetBookmark();
	MeetBookmark findByUserKey(String user_key);
	MeetBookmark findByIdMeetBookmark(int idMeetBookmark);
	int countMeetBookmark();
	void insertMeetBookmark(int idMeetBookmark,
			@Param(value = "user_key") String user_key,
			@Param(value = "idMeeting") int idMeeting);
	void deleteMeetBookmark(int idMeetBookmark);
}
