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
    List<Contest> findAllContest();
    int selectCount();
    Contest getContest(int idContest);
    void insert(Contest contest);
    List<Contest> findByDate(String startDate, String endDate);
    List<Contest> findByKind(String kind);
    List<Contest> findByTarget(String target);
    List<Contest> findByPlace(String place);
    List<Contest> findByTitle(String title);
    List<Contest> findByCountry(String country);
    List<Contest> findBySOC(String SOCName);
}
