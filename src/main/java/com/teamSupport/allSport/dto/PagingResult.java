package com.teamSupport.allSport.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagingResult {
	private List list;
	private PageMaker pageMaker;
	public PageMaker getPageMaker(int totalCount, int page){
		Criteria cri = new Criteria();
		cri.setPage(page);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		return pageMaker;
    }
}
