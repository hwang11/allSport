package com.teamSupport.allSport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.teamSupport.allSport.dto.ContestBookmark;

@Mapper
@Repository
public interface ContestBookmarkMapper {
	List<ContestBookmark> findAllContestBookmark();
	List<ContestBookmark> findByUserKey(String user_key);
	ContestBookmark findByIdContestBookmark(int idContestBookmark);
	int getLast();
	void insertContestBookmark(int idContestBookmark, 
			@Param(value = "user_key") String user_key,
			@Param(value = "idContest") int idContest);
	void deleteContestBookmark(int idContestBookmark);
	void deleteByUserKey(@Param(value = "user_key") String user_key);
}
