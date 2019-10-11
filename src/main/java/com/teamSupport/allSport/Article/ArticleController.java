package com.teamSupport.allSport.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping(path = "/article", method = RequestMethod.GET)
    public @ResponseBody
    List<Article> getArticle() {
        List<Article> posts = articleMapper.getArticle();

        return posts;
    }

    @RequestMapping(path = "/article/articleId", method = RequestMethod.GET)
    public @ResponseBody List<Article> findArticleByArticleId(@RequestParam(value = "idArticle") int idArticle) {
        List<Article> articles = articleMapper.findArticleByArticleId(idArticle);

        return articles;
    }

    @RequestMapping(path = "/article/contestId", method = RequestMethod.GET)
    public @ResponseBody List<Article> findArticleByContestId(@RequestParam(value = "idContest") int idContest) {
        List<Article> articles = articleMapper.findArticleByContestId(idContest);

        return articles;
    }

    @RequestMapping(path = "/article/articleKind", method = RequestMethod.GET)
    public @ResponseBody List<Article> findArticleByKind(@RequestParam(value = "article_kind") String article_kind) {
        List<Article> articles = articleMapper.findArticleByKind(article_kind);

        return articles;
    }

    @RequestMapping(path = "/uploadArticle", method = RequestMethod.POST)
    public @ResponseBody void uploadArticle(@RequestParam(value = "idArticle") int idArticle, @RequestParam(value = "idContest") int idContest,
                                         @RequestParam(value = "article_date") long article_date,
                                         @RequestParam(value = "article_writer_nickname") String article_writer_nickname, @RequestParam(value = "article_kind") String article_kind,
                                         @RequestParam(value = "article_title") String article_title, @RequestParam(value = "article_contents") String article_contents) {

        articleMapper.uploadArticle(idArticle, idContest, article_date, article_writer_nickname, article_kind, article_title, article_contents);

    }
}
