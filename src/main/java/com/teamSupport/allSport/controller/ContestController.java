package com.teamSupport.allSport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dao.ContestMapper;
import com.teamSupport.allSport.dto.Contest;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ContestController {
	@Autowired
	ContestMapper contestMapper;

	@RequestMapping(path = "/contest", method = RequestMethod.GET)
	public @ResponseBody List<Contest> show() {
		List<Contest> li = contestMapper.findAllContest();
		return li;
	}

	@RequestMapping(path = "/contest/{idContest}", method = RequestMethod.GET)
	public @ResponseBody Contest getContest(@PathVariable int idContest) {
		Contest contest = contestMapper.getContest(idContest);
		return contest;
	}

	@RequestMapping(path = "/contest/search", method = RequestMethod.POST)
	public @ResponseBody List<Contest> search(
			@RequestParam(value = "contest_startDate", defaultValue = "aa") String contest_startDate,
			@RequestParam(value = "contest_endDate", defaultValue = "aa") String contest_endDate,
			@RequestParam(value = "contest_kind", defaultValue = "aa") String contest_kind,
			@RequestParam(value = "contest_target", defaultValue = "aa") String contest_target,
			@RequestParam(value = "contest_place", defaultValue = "aa") String contest_place,
			@RequestParam(value = "contest_title", defaultValue = "aa") String contest_title,
			@RequestParam(value = "contest_country", defaultValue = "aa") String contest_country,
			@RequestParam(value = "contest_SOCName", defaultValue = "aa") String contest_SOCName) {
		List<Contest> li;
		if (contest_startDate != null)
			li = contestMapper.findByDate(contest_startDate,contest_endDate);
		else if (!contest_kind.equals("aa")) {
			li = contestMapper.findByKind(contest_kind);
		} else if (!contest_target.equals("aa")) {
			li = contestMapper.findByTarget(contest_target);
		} else if (!contest_place.equals("aa")) {
			li = contestMapper.findByPlace(contest_place);
		} else if (!contest_title.equals("aa")) {
			li = contestMapper.findByTitle(contest_title);
		} else if (!contest_country.equals("aa")) {
			li = contestMapper.findByCountry(contest_country);
		} else {
			li = contestMapper.findBySOC(contest_SOCName);
		}

		return li;
	}

}
