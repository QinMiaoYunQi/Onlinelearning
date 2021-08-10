package com.javen.service;

import java.util.List;

import com.javen.model.Login;
import com.javen.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ILoginService {
	//所有你想要实现的方法一定要在这个地方定义
	
	 public Login selectByPrimaryKey(int id);
	 
	 public int deleteByPrimaryKey(int id);
	 
	 public int insert(Login login);
	 
	 public int updateByPrimaryKey(Login login);

	 public List<Login> selectAll(int pageInteger,int limitInteger);

	 Boolean ifLogin(Login login, HttpServletRequest request, HttpServletResponse response);

	 public int SelectCount();


	 
}
