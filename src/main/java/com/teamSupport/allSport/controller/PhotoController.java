//package com.teamSupport.allSport.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.teamSupport.allSport.dao.PhotoMapper;
//import com.teamSupport.allSport.dto.Photo;
//import com.teamSupport.allSport.dto.ResponseMessage;
//import com.teamSupport.allSport.dto.User;
//import com.teamSupport.allSport.service.PhotoService;
//
//@RestController
//public class PhotoController extends AbstractBaseRestController{
//	@Autowired
//	PhotoService photoService;
//
//	@RequestMapping(path = "/article/{idArticle}/photo", method = RequestMethod.GET)
//	public @ResponseBody ResponseMessage getPhotos(@PathVariable int idArticle) {
//		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
//		message.add("result", photoService.findPhotoByIdArticle(idArticle));
//		return message;
//	}
//
//	@RequestMapping(path = "/photo/{idPhoto}", method = RequestMethod.GET)
//	public @ResponseBody ResponseMessage getPhoto(@PathVariable int idPhoto) {
//		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
//		message.add("result", photoService.findPhotoByIdPhoto(idPhoto));
//		return message;
//	}
//
//	//insert
//	@RequestMapping(path = "/photo", method = RequestMethod.POST)
//	public @ResponseBody ResponseMessage insertPhoto(String photo_path, String photo_type,
//			String photo_name, int idArticle, String photo_size) {
//		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
//		message.add("result", photoService.insertPhoto(photo_path, photo_name, photo_type, photo_size, idArticle));
//		return message;
//	}
//
//	//delete
//	@RequestMapping(path = "/photo/{idPhoto}", method = RequestMethod.DELETE)
//	public @ResponseBody ResponseMessage deletePhoto(@PathVariable int idPhoto) {
//		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
//		message.add("result", photoService.deleteByIdPhoto(idPhoto));
//		return message;
//	}
//
//	@RequestMapping(path = "/article/{idArticle}/photo", method = RequestMethod.DELETE)
//	public @ResponseBody ResponseMessage deletePhotos(@PathVariable int idArticle) {
//		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
//		message.add("result", photoService.deleteByIdArticle(idArticle));
//		return message;
//	}
//
//}
