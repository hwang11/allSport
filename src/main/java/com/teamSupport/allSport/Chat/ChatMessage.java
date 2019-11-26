package com.teamSupport.allSport.Chat;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
	// 메시지 타입 : 입장, 채팅
    public enum MessageType {
        ENTER, TALK, QUIT
    }
    private MessageType chatMessage_type; // 메시지 타입
    private String chatMessage_writer; // 메시지 보낸사람
    private String chatMessage_message; // 메시지
    
    @OneToOne 
   	@JoinColumn(name = "idChatRoom") 
    private int idChatRoom; // 방번호 외래키 

	@Override
	public String toString() {
		return "ChatMessage [chatMessage_type=" + chatMessage_type + ", chatMessage_writer=" + chatMessage_writer
				+ ", chatMessage_message=" + chatMessage_message + ", idChatRoom=" + idChatRoom + "]";
	}
    
}