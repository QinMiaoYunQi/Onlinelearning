package com.javen.controller;

import com.javen.model.Class;
import com.javen.service.IClassService;
import com.javen.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private IClassService iClassService;


    @ResponseBody
    @RequestMapping(value="/selectAll", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception{
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString +" "+ limitString);
        List<Class> listsList = iClassService.selectAll(pageInteger,limitInteger);
        String[] colums = { "id", "className", "foundTime","teacherName"};
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        return data;
    }
    @ResponseBody
    @RequestMapping(value = "/SelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request) {
        int count = iClassService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }



    @ResponseBody
    @RequestMapping(value = "/selectById", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public Class selectById(HttpServletRequest request){
        String id = request.getParameter("id");
        Integer idInteger = Integer.valueOf(id);
        Class cla = iClassService.selectById(idInteger);
        return cla;
    }

    @ResponseBody
    @RequestMapping(value="insert", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request){
        String className = request.getParameter("className");
        String foundTime = request.getParameter("foundTime");
        String teacherName = request.getParameter("teacherName");
        System.out.println(className+" "+foundTime+" "+teacherName);
        System.out.println("-------------------------");
        Class cla = new Class();
        cla.setClassName(className);
        cla.setFoundTime(foundTime);
        cla.setTeacherName(teacherName);
        int count = iClassService.insert(cla);
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
        int count = iClassService.delete(idInteger);
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
        String className = request.getParameter("className");
        String foundTime = request.getParameter("foundTime");
        String teacherName = request.getParameter("teacherName");
        System.out.println(className+" "+foundTime+" "+teacherName);
        System.out.println("-------------------------");
        Class cla = new Class();
        cla.setId(idInteger);
        cla.setClassName(className);
        cla.setFoundTime(foundTime);
        cla.setTeacherName(teacherName);
        int count = iClassService.update(cla);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"修改失败\"}";
        }else{json="{\"count\":\"200\",\"message\":\"修改成功\"}";}
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value="GetTeacher", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String GetTeacher() throws Exception {
        List<Class> listsList = iClassService.selectAll(1,10);
        String[] colums= {"id", "className", "foundTime","teacherName"};
        String json = ObjtoLayJson.ListtoJson(listsList, colums);
        System.out.println(json);
        return json;
    }
}
