package com.javen.dao;

import com.javen.model.Login;
import com.javen.model.User;


import java.util.List;

public interface LoginDao {

    public Login selectByPrimaryKey(int id);

    public int deleteByPrimaryKey(int id);

    public int insert(Login login);

    public int updateByPrimaryKey(Login login);

    public List<Login> selectAll(int pageInteger, int limitInteger);

    public List<Login> login(Login login);

    public int SelectCount();


}
