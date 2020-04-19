package com.teamSupport.allSport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamSupport.allSport.mapper.ChatRoomMapper;
import com.teamSupport.allSport.dto.ChatRoom;
import com.teamSupport.allSport.dto.Criteria;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;
import com.teamSupport.allSport.service.ChatRoomService;

@Service("ChatRoomService")
public class ChatRoomServiceImpl implements ChatRoomService{
	@Autowired
	ChatRoomMapper chatRoomMapper;
	
	@Override 
	public PageMaker getPageMaker(int totalCount, int page){
		Criteria cri = new Criteria();
		cri.setPage(page);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		return pageMaker;
	}
	
	@Override
	public PagingResult findAllRoomByUserKey(String user_key, int page){
		PagingResult result = new PagingResult();
		int totalCount = chatRoomMapper.getLast();
		PageMaker pageMaker = this.getPageMaker(totalCount, page);
		List<ChatRoom> list 
			= chatRoomMapper.findAllRoomByUserKey(user_key, page, pageMaker.getCri().getPageStart(), pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;
	}
	
	@Override
	public ChatRoom findRoomById(int roomId){
		return chatRoomMapper.findRoomById(roomId);
	}
	
	@Override
	public ChatRoom deleteChatRoom(int roomId){
		ChatRoom room = chatRoomMapper.findRoomById(roomId);
		chatRoomMapper.deleteChatRoom(roomId);
		return room;
	}
	
	@Override
	public ChatRoom insertChatRoom(String name, String user_key){
		int id = chatRoomMapper.getLast();
        chatRoomMapper.insertChatRoom(id+1,name,user_key);
		ChatRoom room = new ChatRoom(id+1,name,user_key);
		return room;
	}
}
