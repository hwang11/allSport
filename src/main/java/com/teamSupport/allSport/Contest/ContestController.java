package com.teamSupport.allSport.Contest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.Contest.ContestMapper;
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
    
    @RequestMapping(path = "/getContest", method = RequestMethod.GET) 
    public @ResponseBody Contest getContest(@RequestParam(value = "idContest") int idContest) {
        Contest contest = contestMapper.getContest(idContest);
        return contest;
    }
}
