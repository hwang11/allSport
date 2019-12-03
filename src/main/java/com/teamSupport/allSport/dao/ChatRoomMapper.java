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
	List<ChatRoom> findAllRoomByUserKey(String user_key);
	ChatRoom findRoomById(@Param(value = "roomId") int roomId);
	void deleteChatRoom(@Param(value = "roomId") int roomId);
	void insertChatRoom(@Param(value = "roomId") int roomId, @Param(value = "name") String name,
			@Param(value = "user_key") String user_key);
}
