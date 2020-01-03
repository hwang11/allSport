package com.teamSupport.allSport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamSupport.allSport.dao.ArticleMapper;
import com.teamSupport.allSport.dao.ContestBookmarkMapper;
import com.teamSupport.allSport.dto.Article;
import com.teamSupport.allSport.dto.ContestBookmark;
import com.teamSupport.allSport.dto.Criteria;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;
import com.teamSupport.allSport.service.ContestBookmarkService;

@Service
public class ContestBookmarkServiceImpl implements ContestBookmarkService{
	@Autowired
	ContestBookmarkMapper contestBookmarkMapper;

	@Override 
	public PageMaker getPageMaker(int totalCount, int page){
		Criteria cri = new Criteria();
		cri.setPage(page);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		return pageMaker;
	}
	
	@Override
	public PagingResult findByUserKey(String user_key, int page){
		PagingResult result = new PagingResult();
		int totalCount = contestBookmarkMapper.getLast();
		PageMaker pageMaker = this.getPageMaker(totalCount, page);
		List<ContestBookmark> list  = contestBookmarkMapper.findByUserKey(user_key, 
				pageMaker.getCri().getPageStart(), pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;

	}
	@Override
	public ContestBookmark findByIdContestBookmark(int idContestBookmark){
		return contestBookmarkMapper.findByIdContestBookmark(idContestBookmark);
	}
	
	@Override
	public ContestBookmark insertContestBookmark(String user_key, int idContest){
		int bookmarkId = contestBookmarkMapper.getLast();
		contestBookmarkMapper.insertContestBookmark(bookmarkId + 1, user_key, idContest);
		return new ContestBookmark(bookmarkId + 1, user_key, idContest);
	}
	
	@Override
	public ContestBookmark deleteContestBookmark(int idContestBookmark){
		ContestBookmark bookmark = contestBookmarkMapper.findByIdContestBookmark(idContestBookmark);
		contestBookmarkMapper.deleteContestBookmark(idContestBookmark);
		return bookmark;
	}
	@Override
	public List<ContestBookmark> deleteByUserKey(String user_key){
		List<ContestBookmark> list = contestBookmarkMapper.findByUserKey(user_key, 0, 0);
		contestBookmarkMapper.deleteByUserKey(user_key);
		return list;
	}
}
