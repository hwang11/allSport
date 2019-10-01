package com.teamSupport.allSport.Article;

import org.apache.ibatis.annotations.Param;

import java.util.List;

interface ArticleMapper {
    List<Article> getArticle();
    List<Article> findArticleByArticleId(int idArticle);
    List<Article> findArticleByContestId(int idContest);
    List<Article> findArticleByKind(String article_kind);
    void uploadArticle(@Param(value = "idArticle") int idArticle, @Param(value = "idContest") int idContest,
                       @Param(value = "article_date") long article_date,
                       @Param(value = "article_writer_nickname") String article_writer_nickname, @Param(value = "article_kind") String article_kind,
                       @Param(value = "article_title") String article_title, @Param(value = "article_contents") String article_contents);
}
