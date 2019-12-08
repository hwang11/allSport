package com.teamSupport.allSport.dto;

import org.springframework.data.annotation.Id;


import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Contest {
	@Id
	private int idContest;
	private int contest_num; // 
	private String contest_startDate; //date로 형식 바꾸기  
	private String contest_endDate; //date 
	private String contest_SOCName; //주최기관 
	private String contest_kind; //종목 
	private String contest_title; //제목 
	private String contest_contents; // 내용 
	private String contest_country; //국내/국제 
	private String contest_target; //대상 
	private String contest_place; //장소 
	private String contest_URL;
	private String contest_phone;
	
	
}