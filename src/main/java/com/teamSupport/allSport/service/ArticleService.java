package com.teamSupport.allSport.service;

import java.util.List;

import com.teamSupport.allSport.dto.Article;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;

public interface ArticleService {
	public PagingResult getAllArticle(int page);
	public PagingResult articleSearch(int page,int idContest, String date, String writer_nickname,
			String kind, String title);
	public Article getArticle(int idArticle);
	public Article insertArticle(int idContest, String writer_nickname,
								 String kind, String title, String contents);
	public Article updateArticle(int idArticle,int idContest, String kind,
			String title, String contents);
	public Article deleteArticle(int idArticle);
}
