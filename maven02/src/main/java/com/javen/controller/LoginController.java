package com.javen.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.util.ObjtoLayJson;
import com.javen.model.Login;
import com.javen.service.ILoginService;

@Controller  //返回指定页面  ajax 不能接受到页面的返回 ，所以说
@RequestMapping("/login") 
public class LoginController {  
	
	private static Logger log=LoggerFactory.getLogger(LoginController.class);
	
	@Resource  
	private ILoginService loginService;     
    
    // /user/test?id=1
    @RequestMapping(value="/back", method=RequestMethod.GET)
    public String test(HttpServletRequest request,Model model){  
        return "back"; 
    }
	@RequestMapping(value="/teacher", method=RequestMethod.GET)   //
	public String teacher(HttpServletRequest request,Model model){
		return "teacher";
	}
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin(HttpServletRequest request,Model model){
		return "admin";
	}
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String student(HttpServletRequest request,Model model){
		return "student";
	}
	@RequestMapping(value="/TeacherLeave", method=RequestMethod.GET)   //跳转到教师请假
	public String TeacherLeave(HttpServletRequest request,Model model){
		return "TeacherLeave";
	}
	@RequestMapping(value="/fileContent", method=RequestMethod.GET)   //跳转到课件管理
	public String fileContent(HttpServletRequest request,Model model){
		return "fileContent";
	}
	@RequestMapping(value="/homework", method=RequestMethod.GET)   //跳转到每日作业管理
	public String homework(HttpServletRequest request,Model model){
		return "homework";
	}
	@RequestMapping(value="/Correct", method=RequestMethod.GET)   //跳转到教师评分管理
	public String Correct(HttpServletRequest request,Model model){
		return "Correct";
	}
	@RequestMapping(value="/DoWork", method=RequestMethod.GET)   //跳转到学生写作业界面
	public String DoWork(HttpServletRequest request,Model model){
		return "DoWork";
	}

    @ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response){
    	String phoneString = request.getParameter("phone");
    	String passwordString = request.getParameter("password");
    	String typeString=request.getParameter("type");
    	Integer typeInt=Integer.valueOf(typeString);
		System.out.println(phoneString + " " + passwordString+" "+typeString+" "+typeInt);
		Login aaa=new Login();
		aaa.setPhone(phoneString);
		aaa.setPassword(passwordString);
		aaa.setType(typeInt);
		if(typeInt==2)
		{
			if (loginService.StudentLogin(aaa,request,response)){
				return "{\"data\":\"学生账号\"}";
			}else {
				return  "{\"data\":\"账号密码有误\"}";
			}
		}else if (typeInt==0)
		{
			if (loginService.ifLogin(aaa,request,response)){
				return "{\"data\":\"管理员账号\"}";
			}else {
				return  "{\"data\":\"账号密码有误\"}";
			}
		}else {
			if (loginService.ifLogin(aaa,request,response)){
				return "{\"data\":\"教师账号\"}";
			}else {
				return  "{\"data\":\"账号密码有误\"}";
			}
		}
	}

	@ResponseBody
	@RequestMapping(value="/CookieName", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
	public String CookieName(HttpServletRequest request, HttpServletResponse response) throws Exception   //显示homework表中所有作业的信息
	{
		String nameString = request.getParameter("name");
		System.out.println("作业名： "+nameString);
		Cookie workName=new Cookie("workName",nameString);
		response.addCookie(workName);
		System.out.println(workName.getName());
		String json="";
		json="{\"count\":\"200\",\"message\":\"Cookie设置成功\"}";
		return json;
	}
    
    /*//返回字符串
    @ResponseBody
    @RequestMapping(value="/selectById", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String selectById(HttpServletRequest request) throws Exception{  
    	String  idString = request.getParameter("id");
    	Integer idInteger = Integer.valueOf(idString);
    	Login login = loginService.selectByPrimaryKey(idInteger);
    	System.out.println(login.toString());
    	String[] colums = {"id","userName","password"};
    	String data = ObjtoLayJson.toJson(login, colums);
    	System.out.println(data);
        return data;
    }
    
    @ResponseBody
    @RequestMapping(value="/deleteByPrimaryKey", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String deleteByPrimaryKey(HttpServletRequest request) {
    	String  idString = request.getParameter("id");
    	Integer idInteger = Integer.valueOf(idString);
    	loginService.deleteByPrimaryKey(idInteger);
    	String data = "{\"data\":\"返回成功\"}"; 
        return data; 
    }
    
    @ResponseBody
    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String insert(HttpServletRequest request) {
    	//插入数据库
    	String usernameString = request.getParameter("userName");
    	String passwordString = request.getParameter("password");
    	
    	Login login = new Login();
    	login.setPassword(passwordString);
    	login.setUserName(usernameString);
    	
    	loginService.insert(login);

    	//给前台返回的东西
    	String data = "{\"data\":\"返回成功\"}"; 
        return data; 
    }
    
    @ResponseBody
    @RequestMapping(value="/update", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String update(HttpServletRequest request) {
    	//插入数据库
    	String idString = request.getParameter("id");
    	String usernameString = request.getParameter("userName");
    	String passwordString = request.getParameter("password");
    	Integer idInteger = Integer.valueOf(idString);
    	
    	Login login = new Login();
    	login.setId(idInteger);
    	login.setPassword(passwordString);
    	login.setUserName(usernameString);
    	
    	loginService.updateByPrimaryKey(login);
    	
    	
    	//给前台返回的东西
    	String data = "{\"data\":\"返回成功\"}"; 
        return data; 
    }


	//查询表中有稍等条数据
	@ResponseBody
	@RequestMapping(value = "/SelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String SelectCount(HttpServletRequest request) {
		int count = loginService.SelectCount();
		System.out.println( "count:" + count );
		String data = String.valueOf(count);
		String json= "{"+"\"count\":"+data+"}";
		return json;
	}

    //返回字符串
    @ResponseBody
    @RequestMapping(value="/selectAll", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String selectAll(HttpServletRequest request) throws Exception{
		String pageString = request.getParameter("page");
		String limitString = request.getParameter("limit");
		Integer pageInteger = Integer.valueOf(pageString);
		Integer limitInteger = Integer.valueOf(limitString);
		System.out.println(pageString + limitString);
		List<Login> listsList = loginService.selectAll(pageInteger,limitInteger);
		String[] colums = { "id", "userName", "password"};
		String data = ObjtoLayJson.ListtoJson(listsList, colums);
		return data;
    }*/
   
}  









