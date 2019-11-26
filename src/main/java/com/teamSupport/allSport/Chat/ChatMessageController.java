package com.teamSupport.allSport.Chat;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.teamSupport.allSport.User.User;

@Controller
public class ChatMessageController { // publisher 구현
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
		int id = chatMessageMapper.selectCount();
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
