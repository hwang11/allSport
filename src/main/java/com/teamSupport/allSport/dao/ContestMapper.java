package com.teamSupport.allSport.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.teamSupport.allSport.dto.Contest;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public
interface ContestMapper {
    List<Contest> findAllContest(int pageStart, int perPageNum);
    int getLast();
    int getCountByOption(String startDate, String endDate, String kind, String target,
    		String place, String title, String country, String SOCName);
    Contest getContest(int idContest);
    void insert(Contest contest);
    List<Contest> findByOption(String startDate, String endDate, String kind, String target,
    		String place, String title, String country, String SOCName, int pageStart, int perPageNum);
}
