package com.teamSupport.allSport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.teamSupport.allSport.dto.ChatRoom;
import com.teamSupport.allSport.dto.MeetBookmark;

@Mapper
@Repository
public interface ChatRoomMapper {
	int getLast();
	List<ChatRoom> findAllRoomByUserKey(String user_key, int page, int pageStart, int perPageNum);
	ChatRoom findRoomById(int roomId);
	void deleteChatRoom(int roomId);
	void insertChatRoom( int roomId, String name, String user_key);
}
