package com.teamSupport.allSport.Follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FollowController {
    @Autowired
    private FollowMapper followMapper;

    @RequestMapping(path = "/following", method = RequestMethod.GET)
    public @ResponseBody List<Follow> getFollowing(String follower_nickname) {
        List<Follow> followList = followMapper.getFollowing(follower_nickname);

        return followList;
    }

    @RequestMapping(path = "/follower", method = RequestMethod.GET)
    public @ResponseBody List<Follow> getFollower(String following_nickname) {
        List<Follow> followList = followMapper.getFollwer(following_nickname);

        return followList;
    }

    @RequestMapping(path = "/addFollow", method = RequestMethod.POST)
    public @ResponseBody void addFollow(String following_nickname, String follower_nickname) {
        Follow follow = new Follow(following_nickname, follower_nickname);
        followMapper.addFollow(following_nickname, follower_nickname);
    }

}
