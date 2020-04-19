package com.teamSupport.allSport.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.teamSupport.allSport.dto.Contest;

import java.util.List;

@Mapper
@Repository
public
interface ContestMapper {
    void insert(Contest contest);
    Contest getContest(int idContest);
    List<Contest> findAllContest(int pageStart, int perPageNum);
    List<Contest> findByPeriod(String startDate, String endDate, int pageStart, int perPageNum);
    List<Contest> findByLocal(String local, int pageStart, int perPageNum);
    List<Contest> findByTitle(String title, int pageStart, int perPageNum);
    int getLast();
    int getCountByOption(String startDate, String endDate, String kind, String target,
    		String place, String title, String country, String SOCName);
}
