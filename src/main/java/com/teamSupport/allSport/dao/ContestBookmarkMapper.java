package com.teamSupport.allSport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.teamSupport.allSport.dto.Article;
import com.teamSupport.allSport.dto.ContestBookmark;

@Mapper
@Repository
public interface ContestBookmarkMapper {
	List<ContestBookmark> findByUserKey(String user_key, int pageStart, int perPageNum);
	ContestBookmark findByIdContestBookmark(int idContestBookmark);
	int getLast();
	void insertContestBookmark(int idContestBookmark, String user_key, int idContest);
	void deleteContestBookmark(int idContestBookmark);
	void deleteByUserKey(String user_key);
}
