package com.javen.controller;

import com.javen.model.User;
import com.javen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;


    @ResponseBody
    @RequestMapping("/findUser")
    public List<User> findUser(){
       List<User> userList =  iUserService.getUser();
       return userList;
    }

}
