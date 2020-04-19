package com.teamSupport.allSport.dto;

import org.springframework.data.annotation.Id;


import lombok.*;

@Getter @Setter
@Builder
public class Contest {
	@Id
	private int idContest;
	private String contest_startDate;
	private String contest_endDate;
	private String contest_title; //제목
	private String contest_URL;
	private String contest_local;
}