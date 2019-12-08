package com.teamSupport.allSport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.PhotoMapper;
import com.teamSupport.allSport.dto.Photo;
import com.teamSupport.allSport.dto.User;

@RestController
public class PhotoController {
	@Autowired
	PhotoMapper photoMapper;
	
	@RequestMapping(path = "/article/{idArticle}/photo", method = RequestMethod.GET) 
	public @ResponseBody List<Photo> getPhotos(@PathVariable int idArticle) {
		List<Photo> photolist = photoMapper.findPhotoByIdArticle(idArticle);
		return photolist;
	}
	
	@RequestMapping(path = "/photo/{idPhoto}", method = RequestMethod.GET) 
	public @ResponseBody Photo getPhoto(@PathVariable int idPhoto) {
		Photo photo = photoMapper.findPhotoByIdPhoto(idPhoto);
		return photo;
	}
	
	//insert
	@RequestMapping(path = "/photo", method = RequestMethod.POST) 
	public @ResponseBody Photo insertPhoto(String photo_path, String photo_type, 
			String photo_name, int idArticle, String photo_size) {
		int idPhoto = photoMapper.getLast();
		Photo photo = new Photo(idPhoto+1, photo_path,photo_name,photo_type,photo_size,idArticle);
		photoMapper.insertPhoto(idPhoto+1, photo_path,photo_name,photo_type,photo_size,idArticle);
		return photo;
	}
	
	//delete
	@RequestMapping(path = "/photo/{idPhoto}", method = RequestMethod.DELETE) 
	public @ResponseBody Photo deletePhoto(@PathVariable int idPhoto) {
		Photo photo = photoMapper.findPhotoByIdPhoto(idPhoto);
		photoMapper.deleteByIdPhoto(idPhoto);
		return photo;
	}
	
	@RequestMapping(path = "/article/{idArticle}/photo", method = RequestMethod.DELETE) 
	public @ResponseBody List<Photo> deletePhotos(@PathVariable int idArticle) {
		List list = photoMapper.findPhotoByIdArticle(idArticle);
		photoMapper.deleteByIdArticle(idArticle);
		return list;
	}

}
