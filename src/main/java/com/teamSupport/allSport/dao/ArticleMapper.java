package com.teamSupport.allSport.dao;

import org.apache.ibatis.annotations.Param;

import com.teamSupport.allSport.dto.Article;

import java.util.List;

public interface ArticleMapper {
	int getLast();
    Article findByIdArticle(int idArticle);
    List<Article> selectArticle(int pageStart, int perPageNum);
    List<Article> getArticle();
    List<Article> findByIdContest(int idContest);
    List<Article> findByKind(String article_kind);
    List<Article> findByDate(String article_date);
    List<Article> findByWriterNickname(String article_writer_nickname);
    List<Article> findByTitle(String article_title);
    void updateIdContest(int idContest, int idArticle);
    void updateKind(String article_kind, int idArticle);
    void updateTitle(String article_title, int idArticle);
    void updateContents(String article_contents, int idArticle);
    void deleteByIdArticle(int idArticle);
    void deleteByIdContest(int idContest);
    void insertArticle(@Param(value = "idArticle") int idArticle, @Param(value = "idContest") int idContest,
                       @Param(value = "article_date") String article_date,
                       @Param(value = "article_writer_nickname") String article_writer_nickname, @Param(value = "article_kind") String article_kind,
                       @Param(value = "article_title") String article_title, @Param(value = "article_contents") String article_contents);
}
