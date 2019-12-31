package com.teamSupport.allSport.service;

import java.util.List;

import com.teamSupport.allSport.dto.ContestBookmark;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;

public interface ContestBookmarkService {
	public PageMaker getPageMaker(int totalCount, int page);
	public PagingResult findByUserKey(String user_key, int page);
	public ContestBookmark findByIdContestBookmark(int idContestBookmark);
	public ContestBookmark insertContestBookmark(String user_key, int idContest);
	public ContestBookmark deleteContestBookmark(int idContestBookmark);
	public List<ContestBookmark> deleteByUserKey(String user_key);
}
