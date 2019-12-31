package com.teamSupport.allSport.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamSupport.allSport.dao.ArticleMapper;
import com.teamSupport.allSport.dto.Article;
import com.teamSupport.allSport.dto.Criteria;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleMapper articleMapper;
	
	@Override
	public PagingResult getAllArticle(int page) {
		PagingResult result = new PagingResult();
		int totalCount = articleMapper.getLast();
		PageMaker pageMaker = result.getPageMaker(totalCount, page);
		List<Article> list 
			= articleMapper.getAllArticle(page, pageMaker.getCri().getPageStart(), pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;
	}
	
	@Override
	public PagingResult articleSearch(int page,int idContest, String date, String writer_nickname,
			String kind, String title) {
		PagingResult result = new PagingResult();
		int totalCount = articleMapper.getCountByOption(idContest, date, writer_nickname, kind, title);
		PageMaker pageMaker = result.getPageMaker(totalCount, page);
		List<Article> list = articleMapper.articleSearch(page, idContest, date, writer_nickname,
				kind, title, pageMaker.getCri().getPageStart(), pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;
	}
	
	@Override
	public Article getArticle(int idArticle) {
		return articleMapper.findByIdArticle(idArticle);
	}
	
	@Override
	public Article insertArticle(int idContest, String writer_nickname,
			String kind, String title, String contents) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format1.format(System.currentTimeMillis());
		int idArticle = articleMapper.getLast();
		articleMapper.insertArticle(idArticle + 1, idContest, date, writer_nickname, kind,
				title, contents);
		return new Article(idArticle + 1, kind, title, writer_nickname, contents,
				idContest, date);
	}
	
	@Override
	public Article updateArticle(int idArticle,int idContest, String kind,
			String title, String contents) {
		articleMapper.updateArticle(idArticle, idContest, kind, title, contents);
		return articleMapper.findByIdArticle(idArticle);
	}
	
	@Override
	public Article deleteArticle(int idArticle) {
		Article article = articleMapper.findByIdArticle(idArticle);
		articleMapper.deleteByIdArticle(idArticle);
		return article;
	}
}
