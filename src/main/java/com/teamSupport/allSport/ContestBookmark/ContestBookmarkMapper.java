package com.teamSupport.allSport.ContestBookmark;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ContestBookmarkMapper {
	List<ContestBookmark> findAllContestBookmark();
	ContestBookmark findByUserKey(String user_key);
	ContestBookmark findByIdContestBookmark(int idContestBookmark);
	void insertContestBookmark(
			@Param(value = "idContestBookmark") int idContestBookmark, 
			@Param(value = "user_key") String user_key,
			@Param(value = "idContest") int idContest);
	void deleteContestBookmark(int idContestBookmark);
	
}
