package com.teamSupport.allSport.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.teamSupport.allSport.dto.Photo;

@Mapper
@Repository
public interface PhotoMapper {
	int getLast();
	List<Photo> findPhotoByIdArticle(@Param(value = "idArticle") int idArticle);
	Photo findPhotoByIdPhoto(@Param(value = "idPhoto") int idPhoto);
	void deleteByIdArticle(@Param(value = "idArticle") int idArticle);
	void deleteByIdPhoto(@Param(value = "idPhoto") int idPhoto);
	void insertPhoto(@Param(value = "idPhoto") int idPhoto,@Param(value = "photo_path") String photo_path,
			@Param(value = "photo_name") String photo_name, @Param(value = "photo_type") String photo_type,
			@Param(value = "photo_size") String photo_size, @Param(value = "idArticle") int idArticle);
}
