package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.teamSupport.allSport.mapper.ChatMessageMapper;
import com.teamSupport.allSport.dto.ChatMessage;

@Controller
public class ChatMessageController extends AbstractBaseRestController{ // publisher 구현
	@Autowired
	ChatMessageMapper chatMessageMapper;

	private final SimpMessagingTemplate template;
	// SimpMessagingTemplate @EnableWebSocketMessageBroker를 통해서 등록되는 bean이다.
	// 특정 Broker로 메시지를 전달한다.

	@Autowired
	public ChatMessageController(SimpMessagingTemplate template) {
		this.template = template;
	}
	//@MessageMapping을 통해 Websocket으로 들어오는 메시지 발행을 처리
	@MessageMapping("/chat") //test용 
	public void chat(ChatMessage chatMessage) {
		int id = chatMessageMapper.getLast();
		chatMessageMapper.insertChatMessage(id+1,"type",
				chatMessage.getChatMessage_writer(), chatMessage.getChatMessage_message(), 1);
		template.convertAndSend("/topic/chat", chatMessage);
	}
	
//	@MessageMapping("/chat") //완성 
//	public void chat(ChatMessage chatMessage) {
//		int id = chatMessageMapper.selectCount();
//		chatMessageMapper.insertChatMessage(id+1,chatMessage.getChatMessage_type().toString(),
//				chatMessage.getChatMessage_writer(), chatMessage.getChatMessage_message(), 
//				chatMessage.getIdChatRoom());
//		template.convertAndSend("/topic/chat/"+chatMessage.getIdChatRoom() , chatMessage);
//	}

}
