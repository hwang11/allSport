package com.teamSupport.allSport.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    private int idArticle;
    private String article_kind;
    private String article_title;
    private String article_writer_nickname;
    private String article_contents;
    @OneToOne 
   	@JoinColumn(name = "idContest")
   	private int idContest;
    private String article_date;

}
