package com.javen.controller;


import com.javen.model.Student;
import com.javen.model.Teacher;
import com.javen.service.ITeacherService;
import com.javen.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ITeacherService iTeacherService;

    @ResponseBody
    @RequestMapping(value = "/SelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request) {
        int count = iTeacherService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/selectAll", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception   //显示学生表中所有学生的信息
    {
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageInteger +" "+ limitInteger);
        List<Teacher> listsList = iTeacherService.selectAll(pageInteger,limitInteger);
        String[] colums = { "id", "name", "phone","password", "className" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        return data;
    }

    @ResponseBody
    @RequestMapping(value="insert", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request)    //添加学生信息
    {
        String nameString = request.getParameter("name");
        String phoneString = request.getParameter("phone");
        String passwordString = request.getParameter("password");
        String classNameString = request.getParameter("className");
        System.out.println(nameString+" "+phoneString+" "+passwordString+" "+classNameString);
        System.out.println("-------------------------");
        Teacher teacher = new Teacher();
        teacher.setName(nameString);
        teacher.setPhone(phoneString);
        teacher.setPassword(passwordString);
        teacher.setClassName(classNameString);
        int count = iTeacherService.insert(teacher);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"添加失败\"}";
        }else{
            json="{\"count\":\"200\",\"message\":\"添加成功\"}";
        }
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value="delete", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String delete(HttpServletRequest request)    //删除
    {
        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        System.out.println("id: "+idInteger);
        Integer count = iTeacherService.delete(idInteger);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"删除失败\"}";
        }else{json="{\"count\":\"200\",\"message\":\"删除成功\"}";}
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value="update", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String update(HttpServletRequest request)     //修改功能
    {
        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        String nameString = request.getParameter("name");
        String phoneString = request.getParameter("phone");
        String passwordString = request.getParameter("password");
        String classNameString = request.getParameter("className");
        System.out.println(idInteger+" "+nameString+" "+phoneString+" "+passwordString+" "+classNameString);
        System.out.println("...............");
        Teacher teacher = new Teacher();
        teacher.setId(idInteger);
        teacher.setName(nameString);
        teacher.setPhone(phoneString);
        teacher.setPassword(passwordString);
        teacher.setClassName(classNameString);
        int count = iTeacherService.update(teacher);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"修改失败\"}";
        }else {
            json="{\"count\":\"200\",\"message\":\"修改成功\"}";
        }
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/likeByName", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String likeByName(HttpServletRequest request) throws Exception   //搜索查询功能
    {
        String phoneString = request.getParameter("phone");
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(phoneString+" "+pageString +" "+ limitString);
        List<Teacher> teachers = iTeacherService.likeByName(phoneString,pageInteger,limitInteger);
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
        String[] colums = { "id", "name", "phone","password", "className" };
        String data = ObjtoLayJson.ListtoJson(teachers, colums);
        System.out.println(data);
        return data;
    }

}
