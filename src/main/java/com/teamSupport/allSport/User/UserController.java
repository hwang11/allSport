package com.teamSupport.allSport.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	@Autowired
    UserMapper userMapper;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers() {
        List<User> user = userMapper.findAllUsers();
        return user;
    }

    @RequestMapping(path = "/getUser", method = RequestMethod.GET)
    public @ResponseBody User getUser(@RequestParam(value = "user_key") String user_key) {
        User user = userMapper.getUser(user_key);

        return user;
    }

    @RequestMapping(path = "/insertUser", method = RequestMethod.POST)
    public @ResponseBody User insertUser(@RequestParam(value = "user_key") String user_key,
                                         @RequestParam(value = "user_nickname") String user_nickname) {
        User user = new User(user_key, user_nickname);
        userMapper.insertUser(user_key, user_nickname);
        return user;
    }
    
    

}
