package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.teamSupport.allSport.dao.ArticleMapper;
import com.teamSupport.allSport.dto.Article;
import com.teamSupport.allSport.dto.Criteria;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;
import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.service.ArticleService;


@Controller
@RequestMapping(path = "/article")
public class ArticleController extends AbstractBaseRestController{
	@Autowired
	ArticleService articleService;
	
	@RequestMapping(method = RequestMethod.GET) //ok
	public @ResponseBody ResponseMessage getArticle(@RequestParam(value = "page", defaultValue = "0") int page)  {
		 ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	     message.add("result", articleService.getAllArticle(page));
	     return message;
	}

	@RequestMapping(path = "/{idArticle}", method = RequestMethod.GET) //ok
	public @ResponseBody ResponseMessage findArticleByIdArticle(@PathVariable int idArticle) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", articleService.getArticle(idArticle));
		return message;
	}

	@RequestMapping(method = RequestMethod.POST) ///ok
	public @ResponseBody ResponseMessage insertArticle(int idContest, String writer_nickname, 
			String kind, String title, String contents) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", articleService.insertArticle(idContest, writer_nickname, kind, 
				title, contents));
		return message;
	}

	@RequestMapping(path = "/{idArticle}", method = RequestMethod.PATCH) //ok 
	public @ResponseBody ResponseMessage updateArticle(
			@PathVariable int idArticle,
			@RequestParam(value = "idContest", defaultValue = "0") int idContest,
			@RequestParam(value = "kind", defaultValue = "aa") String kind,
			@RequestParam(value = "title", defaultValue = "aa") String title,
			@RequestParam(value = "contents", defaultValue = "aa") String contents) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", articleService.updateArticle(idArticle, idContest, kind, 
				title, contents));
		return message;
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.POST) //ok
	public @ResponseBody ResponseMessage search(int page,
			@RequestParam(value = "idContest", defaultValue = "0") int idContest,
			@RequestParam(value = "date", defaultValue = "aa") String date,
			@RequestParam(value = "writer_nickname", defaultValue = "aa") String writer_nickname,
			@RequestParam(value = "kind", defaultValue = "aa") String kind,
			@RequestParam(value = "title", defaultValue = "aa") String title) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", articleService.articleSearch(page, idContest, date, writer_nickname, kind,
				title));
		return message;
	}
	
	@RequestMapping(path = "/{idArticle}", method = RequestMethod.DELETE) //ok
	public @ResponseBody ResponseMessage deleteArticle(@PathVariable int idArticle) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", articleService.deleteArticle(idArticle));
		return message;
	}
}
