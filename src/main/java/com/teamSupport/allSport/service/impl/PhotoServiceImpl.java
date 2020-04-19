package com.teamSupport.allSport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamSupport.allSport.mapper.PhotoMapper;
import com.teamSupport.allSport.dto.Photo;
import com.teamSupport.allSport.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{
	@Autowired
	PhotoMapper photoMapper;
	
	@Override
	public List<Photo> findPhotoByIdArticle(int idArticle){
		return photoMapper.findPhotoByIdArticle(idArticle);
	}
	
	@Override
	public Photo findPhotoByIdPhoto(int idPhoto){
		return photoMapper.findPhotoByIdPhoto(idPhoto);
	}
	
	@Override
	public List<Photo> deleteByIdArticle(int idArticle){
		List<Photo> list = photoMapper.findPhotoByIdArticle(idArticle);
		photoMapper.deleteByIdArticle(idArticle);
		return list;
	}
	
	@Override
	public Photo deleteByIdPhoto(int idPhoto){
		Photo photo = photoMapper.findPhotoByIdPhoto(idPhoto);
		photoMapper.deleteByIdPhoto(idPhoto);
		return photo;
	}
	
	@Override
	public Photo insertPhoto(String photo_path,
			String photo_name, String photo_type, String photo_size, int idArticle){
		int idPhoto = photoMapper.getLast()+1;
		photoMapper.insertPhoto(idPhoto, photo_path, photo_name, photo_type, photo_size, idArticle);
		return new Photo(idPhoto, photo_path, photo_name, photo_type, photo_size, idArticle);
	}
}
