package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamSupport.allSport.dao.ChatRoomMapper;
import com.teamSupport.allSport.dto.ChatRoom;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
	   @Autowired
	   ChatRoomMapper chatRoomMapper;
	   
	    // 모든 채팅방 목록 반환
	    @RequestMapping(path = "/room", method = RequestMethod.GET) 
	    public @ResponseBody List<ChatRoom> room(@RequestParam(value = "user_key") String user_key) {
	 	  return chatRoomMapper.findAllRoomByUserKey(user_key);
	    }
	    
	    // 채팅방 생성
	    @RequestMapping(path = "/room", method = RequestMethod.POST) 
	    public @ResponseBody void createRoom(@RequestParam String name, @RequestParam String user_key) {
	    	int id = chatRoomMapper.getLast();
	        chatRoomMapper.insertChatRoom(id+1,name,user_key);
	    }

	    // 특정 채팅방 조회
	    @RequestMapping(path = "/room/{roomId}", method = RequestMethod.GET) 
	    public @ResponseBody ChatRoom roomInfo(@PathVariable int roomId) {
	        return chatRoomMapper.findRoomById(roomId);
	    }
}
