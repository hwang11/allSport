package com.teamSupport.allSport.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.teamSupport.allSport.dto.ChatRoom;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;

public interface ChatRoomService {
	public PageMaker getPageMaker(int totalCount, int page);
	public PagingResult findAllRoomByUserKey(String user_key,int page);
	public ChatRoom findRoomById(int roomId);
	public ChatRoom deleteChatRoom(int roomId);
	public ChatRoom insertChatRoom(String name, String user_key);
}
