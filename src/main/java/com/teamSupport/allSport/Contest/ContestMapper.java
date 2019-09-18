package com.teamSupport.allSport.Contest;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public
interface ContestMapper {
    List<Contest> findAllContest();
    int selectCount();
    Contest getContest(int idContest);
}
