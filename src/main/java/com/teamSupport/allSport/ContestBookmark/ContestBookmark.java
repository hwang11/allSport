package com.teamSupport.allSport.ContestBookmark;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContestBookmark {
	private int idContestBookmark;
	
	@OneToOne //일대일
	@JoinColumn(name = "user_key")  //조인컬럼은 외래키를 매핑할때 사용 (연관관계주인)
	private String user_key;
	
	@OneToOne 
	@JoinColumn(name = "idContest")
	private int idContest;
}
