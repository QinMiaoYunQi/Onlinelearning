package com.javen.controller;

import com.javen.model.Homework;
import com.javen.model.JobName;
import com.javen.service.IHomeworkService;
import com.javen.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
    @Autowired
    private IHomeworkService iHomeworkService;

    @ResponseBody
    @RequestMapping(value = "/SelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request) {
        int count = iHomeworkService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/selectAll", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception{
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString +" "+ limitString);
        String teacherName = request.getParameter("teacherName");
        String className = request.getParameter("className");
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        Map<String,Object> map =  new HashMap<String, Object>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        map.put("teacherName",teacherName);
        map.put("className",className);
        System.out.println(map.get("teacherName"));
        List<Homework> listsList = iHomeworkService.selectAll(map);
        String[] colums = { "id", "jobName", "className","date","teacherName" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        System.out.println(data);
        return data;
    }
    @ResponseBody
    @RequestMapping(value="/insert", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request){
        String teacherName = request.getParameter("teacherName");
        String className = request.getParameter("className");
        String jobName = request.getParameter("jobName");
        Date date = new Date();
        Homework homework = new Homework();
        homework.setClassName(className);
        homework.setTeacherName(teacherName);
        homework.setJobName(jobName);
        homework.setDate(date);
        int count = iHomeworkService.insert(homework);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"添加失败\"}";
        }else{json="{\"count\":\"200\",\"message\":\"添加成功\"}";}
        System.out.println(json);
        return json;
        }
}
