package com.teamSupport.allSport.MeetBookmark;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeetBookmark {
	private int idMeetBookmark;
	
	@OneToOne 
	@JoinColumn(name = "user_key") 
	private String user_key;
	
	@OneToOne 
	@JoinColumn(name = "idMeeting") 
	private int idMeeting;
}
