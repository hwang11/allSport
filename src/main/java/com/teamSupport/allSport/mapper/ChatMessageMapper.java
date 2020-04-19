package com.teamSupport.allSport.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChatMessageMapper {
	int getLast();
	void insertChatMessage(@Param(value = "idChatMessage") int idChatMessage, @Param(value = "type") String type,
			@Param(value = "writer") String writer, @Param(value = "message") String message,
			@Param(value = "idChatRoom") int idChatRoom);
}
