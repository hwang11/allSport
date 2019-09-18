package com.teamSupport.allSport.Contest;

import org.springframework.data.annotation.Id;


import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Contest {
	@Id
	private int id;
	private int num; // 
	private String startDate; //date로 형식 바꾸기  
	private String endDate; //date 
	private String SOCName; //주최기관 
	private String kind; //종목 
	private String title; //제목 
	private String context; // 내용 
	private String country; //국내/국제 
	private String target; //대상 
	private String place; //장소 
	private String URL;
	private String phone;
	@Override
	public String toString() {
		return "Contest [id=" + id + ", num=" + num + ", startDate=" + startDate + ", endDate=" + endDate + ", SOCName="
				+ SOCName + ", kind=" + kind + ", title=" + title + ", context=" + context + ", country=" + country
				+ ", target=" + target + ", place=" + place + ", URL=" + URL + ", phone=" + phone + "]";
	}
	
}