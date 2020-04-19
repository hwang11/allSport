package com.teamSupport.allSport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.service.ContestService;

@RestController
public class ContestController extends AbstractBaseRestController{
	@Autowired
	ContestService contestService;

	@RequestMapping(path = "/contest", method = RequestMethod.GET)
	public @ResponseBody ResponseMessage show(@RequestParam(value = "page", defaultValue = "1") int page) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", contestService.findAllContest(page));
	    return message;
	}

	@RequestMapping(path = "/contest/{idContest}", method = RequestMethod.GET)
	public @ResponseBody ResponseMessage getContest(@PathVariable int idContest) {
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", contestService.getContest(idContest));
	    return message;
	}

	@RequestMapping(path = "/contest/search", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage search(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "startDate", defaultValue = "aa") String startDate,
			@RequestParam(value = "endDate", defaultValue = "aa") String endDate,
			@RequestParam(value = "kind", defaultValue = "aa") String kind,
			@RequestParam(value = "target", defaultValue = "aa") String target,
			@RequestParam(value = "place", defaultValue = "aa") String place,
			@RequestParam(value = "title", defaultValue = "aa") String title,
			@RequestParam(value = "country", defaultValue = "aa") String country,
			@RequestParam(value = "SOCName", defaultValue = "aa") String SOCName) {

		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
	    message.add("result", contestService.search(page, startDate, endDate, kind, target, place, title, country, SOCName));
	    return message;
	}

}
