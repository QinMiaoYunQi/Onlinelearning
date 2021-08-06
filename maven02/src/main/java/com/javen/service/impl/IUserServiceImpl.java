package com.javen.service.impl;

import com.javen.dao.UserDao;
import com.javen.model.User;
import com.javen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl  implements IUserService{

    @Autowired
    private UserDao userDao;

    public List<User> getUser() {
        return this.userDao.getUser();
    }

}
