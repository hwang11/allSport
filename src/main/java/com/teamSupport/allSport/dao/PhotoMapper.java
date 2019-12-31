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
	List<Photo> findPhotoByIdArticle(int idArticle);
	Photo findPhotoByIdPhoto(int idPhoto);
	void deleteByIdArticle(int idArticle);
	void deleteByIdPhoto(int idPhoto);
	void insertPhoto(int idPhoto,String photo_path,
			String photo_name, String photo_type, String photo_size, int idArticle);
}
