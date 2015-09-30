package com.hh.controller;

import com.hh.entity.User;
import com.hh.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 15-9-29.
 */
@Controller
@RequestMapping("userController")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("getAllUsre")
    public ModelAndView getAllUser(){
        List<User> userList = userService.getAllUser();
        for(User user:userList){
            log.error("---:"+user.toString());
        }
        return  new ModelAndView("success");
    }
}
