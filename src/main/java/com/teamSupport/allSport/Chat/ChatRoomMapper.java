package com.teamSupport.allSport.Chat;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.teamSupport.allSport.MeetBookmark.MeetBookmark;

@Mapper
@Repository
public interface ChatRoomMapper {
	int countChatRoom();
	List<ChatRoom> findAllRoomByUserKey(String user_key);
	ChatRoom findRoomById(@Param(value = "roomId") int roomId);
	void deleteChatRoom(@Param(value = "roomId") int roomId);
	void insertChatRoom(@Param(value = "roomId") int roomId, @Param(value = "name") String name,
			@Param(value = "user_key") String user_key);
}
