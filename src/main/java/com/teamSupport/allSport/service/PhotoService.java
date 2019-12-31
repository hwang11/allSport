package com.teamSupport.allSport.service;

import java.util.List;

import com.teamSupport.allSport.dto.Photo;

public interface PhotoService {
	public List<Photo> findPhotoByIdArticle(int idArticle);
	public Photo findPhotoByIdPhoto(int idPhoto);
	public List<Photo> deleteByIdArticle(int idArticle);
	public Photo deleteByIdPhoto(int idPhoto);
	public Photo insertPhoto(String photo_path,
			String photo_name, String photo_type, String photo_size, int idArticle);
}
