package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javen.model.User;
import org.springframework.stereotype.Service;

import com.javen.dao.LoginDao;
import com.javen.model.Login;
import com.javen.service.ILoginService;

@Service
public class ILoginServiceImpl implements ILoginService{

	@Resource
	private LoginDao loginDao;
	
	
	
	public Login selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return this.loginDao.selectByPrimaryKey(id);
	}

	public int deleteByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return this.loginDao.deleteByPrimaryKey(id);
	}

	public int insert(Login login) {
		// TODO Auto-generated method stub
		return this.loginDao.insert(login);
	}

	public int updateByPrimaryKey(Login login) {
		// TODO Auto-generated method stub
		return this.loginDao.updateByPrimaryKey(login);
	}

	/*
	 * pageInteger:代表我们现在在第几页上
	 * limitInteger：每页的个数
	 * (non-Javadoc)
	 * @see com.javen.service.IRegistService#selectAll(int, int)
	 */

	public List<Login> selectAll(int pageInteger, int limitInteger) {

		int pageIndex = (pageInteger-1) * limitInteger;
		int pageSize = limitInteger;

		return this.loginDao.selectAll(pageIndex, pageSize);
	}


	public Boolean ifLogin(Login login, HttpServletRequest request, HttpServletResponse response) {
		List<Login> aaa = loginDao.login(login);
		if (aaa.size() == 1){
			HttpSession session = request.getSession();
			session.setAttribute("phone",aaa.get(0));

			Cookie phone=new Cookie("phone",aaa.get(0).getPhone());
			response.addCookie(phone);
			return true;
		}else {
			return false;
		}
	}

	public int SelectCount() {
		// TODO Auto-generated method stub
		return this.loginDao.SelectCount();
	}



}
