package com.teamSupport.allSport.ContestBookmark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.Contest.ContestMapper;

@RestController
public class ContestBookmarkController {
	@Autowired
	ContestBookmarkMapper contestBookmarkMapper;
		 
   @RequestMapping(path = "/contestBookmark", method = RequestMethod.GET)
   public @ResponseBody List<ContestBookmark> show() {
       List<ContestBookmark> li = contestBookmarkMapper.findAllContestBookmark();
       return li;
   }
   
   @RequestMapping(path = "/getContestByUserkey", method = RequestMethod.GET) 
   public @ResponseBody ContestBookmark getContestByUserkey(@RequestParam(value = "user_key") String user_key) {
	   ContestBookmark contestBookmark = contestBookmarkMapper.findByUserKey(user_key);
       return contestBookmark;
   }
   
   @RequestMapping(path = "/getContestById", method = RequestMethod.GET) 
   public @ResponseBody ContestBookmark getContestById(@RequestParam(value = "idContestBookmark") int idContestBookmark) {
	   ContestBookmark contestBookmark = contestBookmarkMapper.findByIdContestBookmark(idContestBookmark);
       return contestBookmark;
   }
   
   @RequestMapping(path = "/insertContestBookmark", method = RequestMethod.POST)
   public @ResponseBody ContestBookmark insertContestBookmark(@RequestParam(value = "idContestBookmark") int idContestBookmark,
                                        @RequestParam(value = "user_key") String user_key,
                                        @RequestParam(value= "idContest") int idContest) {
       ContestBookmark contestBookmark = new ContestBookmark(idContestBookmark,user_key,idContest);
       contestBookmarkMapper.insertContestBookmark(idContestBookmark,user_key,idContest);
       return contestBookmark;
   }
   
   @RequestMapping(path = "/deleteContestBookmark", method = RequestMethod.DELETE)
   public @ResponseBody String deleteContestBookmark(
		   @RequestParam(value = "idContestBookmark") int idContestBookmark) {
	   contestBookmarkMapper.deleteContestBookmark(idContestBookmark);
	   return "success";
   }
 
}
