package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamSupport.allSport.mapper.ChatRoomMapper;
import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.service.ChatRoomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController extends AbstractBaseRestController{
	   @Autowired
	   ChatRoomMapper chatRoomMapper;
	   @Autowired
	   ChatRoomService chatRoomService;
	   
	    // 모든 채팅방 목록 반환 페이징 
	    @RequestMapping(path = "/room", method = RequestMethod.GET) 
	    public @ResponseBody ResponseMessage room(@RequestParam(value = "user_key") String user_key, int page) {
	    	ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		    message.add("result", chatRoomService.findAllRoomByUserKey(user_key, page));
		    return message;
	    }
	    
	    // 채팅방 생성
	    @RequestMapping(path = "/room", method = RequestMethod.POST) 
	    public @ResponseBody ResponseMessage createRoom(@RequestParam String name, @RequestParam String user_key) {
	    	ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		    message.add("result", chatRoomService.insertChatRoom(name, user_key));
		    return message;
	    }

	    // 특정 채팅방 조회
	    @RequestMapping(path = "/room/{roomId}", method = RequestMethod.GET) 
	    public @ResponseBody ResponseMessage roomInfo(@PathVariable int roomId) {
	    	ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		    message.add("result", chatRoomService.findRoomById(roomId));
		    return message;
	    }
	    
	    @RequestMapping(path = "/room/{roomId}", method = RequestMethod.DELETE) 
	    public @ResponseBody ResponseMessage deleteRoom(@PathVariable int roomId) {
	    	ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		    message.add("result", chatRoomService.deleteChatRoom(roomId));
		    return message;
	    }
}
