package com.javen.controller;

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


    @RequestMapping("/teacher")
    public String back(){
        return "Teacher";
    }
    @ResponseBody
    @RequestMapping(value="/selectAll", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception{
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString +" "+ limitString);
        List<Teacher> listsList = iTeacherService.selectAll(pageInteger,limitInteger);
        String[] colums = { "id", "name", "phone","password", "className" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        return data;
    }
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
    @RequestMapping("/selectById")
    public Teacher selectById(){
        Teacher teacher = iTeacherService.selectById(3);
        return teacher;
    }

    @ResponseBody
    @RequestMapping(value="insert", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request){
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String className = request.getParameter("className");
        System.out.println(name+" "+phone+" "+password+" "+className);
        System.out.println("-------------------------");
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setPhone(phone);
        teacher.setPassword(password);
        teacher.setClassName(className);
        int count = iTeacherService.insert(teacher);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"添加失败\"}";
        }else{json="{\"count\":\"200\",\"message\":\"添加成功\"}";}
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value="delete", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String delete(HttpServletRequest request){
        String id = request.getParameter("id");
        Integer idInteger = Integer.valueOf(id);
        int count = iTeacherService.delete(idInteger);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"删除失败\"}";
        }else{json="{\"count\":\"200\",\"message\":\"删除成功\"}";}
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value="update", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String update(HttpServletRequest request) {
        String id = request.getParameter("id");
        Integer idInteger = Integer.valueOf(id);
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String className = request.getParameter("className");
        System.out.println(id+" "+name+" "+phone+" "+password+" "+className);
        System.out.println("...............");
        Teacher teacher = new Teacher();
        teacher.setId(idInteger);
        teacher.setName(name);
        teacher.setPhone(phone);
        teacher.setPassword(password);
        teacher.setClassName(className);
        int count = iTeacherService.update(teacher);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"修改失败\"}";
        }else{json="{\"count\":\"200\",\"message\":\"修改成功\"}";}
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping("/likeByName")
    public List<Teacher> likeByName() {
        List<Teacher> teachers = iTeacherService.likeByName("熊");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
        return teachers;
    }

}
