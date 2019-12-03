package com.teamSupport.allSport.dto;

import java.util.UUID;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoom {
	private int idChatRoom;
    private String chatRoom_name;
    
    @OneToOne 
	@JoinColumn(name = "user_key") 
	private String user_key;
}
