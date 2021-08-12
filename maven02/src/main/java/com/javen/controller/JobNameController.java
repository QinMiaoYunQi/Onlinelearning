package com.javen.controller;

import com.javen.model.JobName;
import com.javen.service.IJobNameService;
import com.javen.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jobName")
public class JobNameController {
    @Autowired
    private IJobNameService iJobNameService;

    @ResponseBody
    @RequestMapping(value = "/SelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request) {
        int count = iJobNameService.SelectCount();
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
        String jobName = request.getParameter("jobName");
        String fraction = request.getParameter("fraction");
        String className = request.getParameter("className");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString +" "+ limitString);
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        System.out.println("jobName:"+jobName+"fraction:"+fraction);
        Map<String,Object> map =  new HashMap<String, Object>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        map.put("jobName",jobName);
        map.put("fraction",fraction);
        map.put("className",className);
        System.out.println(map.get("jobName"));
        List<JobName> listsList = iJobNameService.selectAll(map);
        String[] colums = { "id","studentName","fraction","jobName","className","content" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        System.out.println(data);
        return data;
    }


    @ResponseBody
    @RequestMapping(value="update", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String update(HttpServletRequest request) {
        String id = request.getParameter("id");
        Integer idInteger = Integer.valueOf(id);
        String fraction = request.getParameter("fraction");
        System.out.println("..............."+fraction);
        JobName jobName = new JobName();
        jobName.setId(idInteger);
        jobName.setFraction(fraction);
        int count = iJobNameService.update(jobName);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"修改失败\"}";
        }else{json="{\"count\":\"200\",\"message\":\"修改成功\"}";}
        System.out.println(json);
        return json;
    }
    @ResponseBody
    @RequestMapping(value="doJob", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String doJob(HttpServletRequest request) {
        String jobName = request.getParameter("jobName");
        String studentName = request.getParameter("studentName");
        String content = request.getParameter("content");
        System.out.println("..............."+studentName);
        JobName job = new JobName();
        job.setJobName(jobName);
        job.setStudentName(studentName);
        job.setContent(content);
        int count = iJobNameService.doJob(job);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"修改失败\"}";
        }else{json="{\"count\":\"200\",\"message\":\"修改成功\"}";}
        System.out.println(json);
        return json;
    }
}
