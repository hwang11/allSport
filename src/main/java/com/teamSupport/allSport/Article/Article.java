package com.teamSupport.allSport.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    private int idArticle;
    private int idContest;
    private long article_date;
    private String article_writer_nickname;
    private String article_kind;
    private String article_title;
    private String article_contents;
}
