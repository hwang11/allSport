package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teamSupport.allSport.dao.ArticleMapper;
import com.teamSupport.allSport.dto.Article;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@RestController
public class ArticleController {
	@Autowired
	ArticleMapper articleMapper;
	
	//페이징 처리 필요 
	@RequestMapping(path = "/article", method = RequestMethod.GET)
	public @ResponseBody List<Article> getArticle() {
		List<Article> posts = articleMapper.getArticle();
		
		return posts;
	}

	@RequestMapping(path = "/article/{idArticle}", method = RequestMethod.GET)
	public @ResponseBody Article findArticleByIdArticle(@PathVariable int idArticle) {
		Article article = articleMapper.findByIdArticle(idArticle);

		return article;
	}

	@RequestMapping(path = "/contest/{idContest}/article", method = RequestMethod.GET)
	public @ResponseBody List<Article> findArticleByIdContest(@PathVariable int idContest) {
		List<Article> articles = articleMapper.findByIdContest(idContest);

		return articles;
	}

	@RequestMapping(path = "/article", method = RequestMethod.POST)
	public @ResponseBody Article insertArticle(@RequestParam(value = "idContest") int idContest,
			@RequestParam(value = "article_writer_nickname") String article_writer_nickname,
			@RequestParam(value = "article_kind") String article_kind,
			@RequestParam(value = "article_title") String article_title,
			@RequestParam(value = "article_contents") String article_contents) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String article_date = format1.format(System.currentTimeMillis());
		int idArticle = articleMapper.getLast();
		articleMapper.insertArticle(idArticle + 1, idContest, article_date, article_writer_nickname, article_kind,
				article_title, article_contents);
		Article article = new Article(idArticle + 1, article_title, article_date, article_writer_nickname, article_kind,
				idContest, article_contents);
		return article;
	}

	@RequestMapping(path = "/article/{idArticle}", method = RequestMethod.PATCH)
	public @ResponseBody Article updateArticle(@PathVariable int idArticle,
			@RequestParam(value = "idContest", defaultValue = "0") int idContest,
			@RequestParam(value = "article_kind", defaultValue = "aa") String article_kind,
			@RequestParam(value = "article_title", defaultValue = "aa") String article_title,
			@RequestParam(value = "article_contents", defaultValue = "aa") String article_contents) {
		Article article = articleMapper.findByIdArticle(idArticle);
		if (idContest != 0) {
			articleMapper.updateIdContest(idContest, idArticle);
			article.setIdContest(idContest);
		}
		if (!article_kind.equals("aa")) {
			articleMapper.updateKind(article_kind, idArticle);
			article.setArticle_kind(article_kind);
		}
		if (!article_title.equals("aa")) {
			articleMapper.updateTitle(article_title, idArticle);
			article.setArticle_title(article_title);
		}
		if (!article_contents.equals("aa")) {
			articleMapper.updateContents(article_contents, idArticle);
			article.setArticle_contents(article_contents);
		}
		return article;
	}

	@RequestMapping(path = "/article/search", method = RequestMethod.POST)
	public @ResponseBody List<Article> search(
			@RequestParam(value = "idContest", defaultValue = "0") int idContest,
			@RequestParam(value = "article_date", defaultValue = "aa") String article_date,
			@RequestParam(value = "article_writer_nickname", defaultValue = "aa") String article_writer_nickname,
			@RequestParam(value = "article_kind", defaultValue = "aa") String article_kind,
			@RequestParam(value = "article_title", defaultValue = "aa") String article_title) {
		List<Article> li;
		if(idContest != 0) {
			li = articleMapper.findByIdContest(idContest);
		}
		else if (!article_date.equals("aa")) {
			li = articleMapper.findByDate(article_date);
		} else if (!article_writer_nickname.equals("aa")) {
			li = articleMapper.findByWriterNickname(article_writer_nickname);
		} else if (!article_kind.equals("aa")) {
			li = articleMapper.findByKind(article_kind);
		} else {
			li = articleMapper.findByTitle(article_title);
		}

		return li;
	}

	@RequestMapping(path = "/article/{idArticle}", method = RequestMethod.DELETE)
	public @ResponseBody Article deleteByIdArticle(@PathVariable int idArticle) {
		Article article = articleMapper.findByIdArticle(idArticle);
		articleMapper.deleteByIdArticle(idArticle);
		return article;
	}

	@RequestMapping(path = "/contest/{idContest}/article", method = RequestMethod.DELETE)
	public @ResponseBody List<Article> deleteByIdContest(@PathVariable int idContest) {
		List list = articleMapper.findByIdContest(idContest);
		articleMapper.deleteByIdContest(idContest);
		return list;
	}
}
