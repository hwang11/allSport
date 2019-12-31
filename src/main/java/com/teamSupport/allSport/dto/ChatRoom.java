package com.teamSupport.allSport.dto;

import java.util.UUID;

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
public class ChatRoom {
	private int idChatRoom;
    private String chatRoom_name;
    
    @OneToOne 
	@JoinColumn(name = "user_key") 
	private String user_key;
}
