package com.teamSupport.allSport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamSupport.allSport.dao.ContestMapper;
import com.teamSupport.allSport.dto.Contest;
import com.teamSupport.allSport.dto.Criteria;
import com.teamSupport.allSport.dto.PageMaker;
import com.teamSupport.allSport.dto.PagingResult;

@Service
public class ContestServiceImpl implements ContestService{
	@Autowired
	ContestMapper contestMapper;
	
	@Override 
	public PageMaker getPageMaker(int totalCount, int page){
		Criteria cri = new Criteria();
		cri.setPage(page);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		return pageMaker;
	}
	
	@Override
	public PagingResult findAllContest(int page){
		PagingResult result = new PagingResult();
		int totalCount = contestMapper.getLast();
		PageMaker pageMaker = this.getPageMaker(totalCount, page);
		List<Contest> list = contestMapper.findAllContest(pageMaker.getCri().getPageStart(), 
				pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;
		
	}
	
	@Override
	public Contest getContest(int idContest){
		return contestMapper.getContest(idContest);
	}
	public PagingResult search(int page, String startDate, String endDate, String kind, String target,
    		String place, String title, String country, String SOCName){
		PagingResult result = new PagingResult();
		int totalCount = contestMapper.getCountByOption(startDate, endDate, kind, target, place, title, country, SOCName);
		PageMaker pageMaker = this.getPageMaker(totalCount, page);
		List<Contest> list = contestMapper.findByOption(startDate, endDate, kind, target, place, title, 
				country, SOCName, pageMaker.getCri().getPageStart(), pageMaker.getCri().getPerPageNum());
		result.setList(list);
		result.setPageMaker(pageMaker);
		return result;
	}
}
