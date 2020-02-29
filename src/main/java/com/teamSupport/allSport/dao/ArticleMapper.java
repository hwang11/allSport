package com.teamSupport.allSport.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamSupport.allSport.dto.Article;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    public int getLast();
	public Article article(int idArticle);
	int getCountByOption(int idContest, String date, String writer_nickname,
			String kind, String title);
    Article findByIdArticle(int idArticle);
    List<Article> getAllArticle(int page, int pageStart, int perPageNum);
    List<Article> articleSearch(int page,int idContest, String date, String writer_nickname,
			String kind, String title, int pageStart, int perPageNum);
    void updateArticle(int idArticle,int idContest, String kind, String title, String contents);
    void deleteByIdArticle(int idArticle);
    void deleteByIdContest(int idContest);
    void insertArticle(@Param(value = "idContest") int idContest,
                       @Param(value = "date") String date,
                       @Param(value = "writer_nickname") String writer_nickname, @Param(value = "kind") String kind,
                       @Param(value = "title") String title, @Param(value = "contents") String contents);
}
