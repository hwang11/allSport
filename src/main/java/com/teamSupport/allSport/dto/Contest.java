package com.teamSupport.allSport.dto;

import org.springframework.data.annotation.Id;


import lombok.*;

@Getter @Setter
@Builder
public class Contest {
	@Id
	private int idContest;
	private String contest_startDate; //date로 형식 바꾸기  
	private String contest_endDate; //date 
	private String contest_title; //제목
	private String contest_URL;
	private String contest_local;
}