package com.teamSupport.allSport.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
    @Id
    private int idMeeting;
    private String meet_name;
    private int meet_nowcount;
    private int meet_maxcount;
    private String meet_location;
    private String meet_contents;
    @OneToOne 
	@JoinColumn(name = "idContest")
	private int idContest;
}
