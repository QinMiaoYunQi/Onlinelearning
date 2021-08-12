package com.javen.controller;


import com.javen.model.Teacher;
import com.javen.model.Work;
import com.javen.service.IWorkService;
import com.javen.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/homework")
public class WorkController {
    @Autowired
    private IWorkService iWorkService;

    @ResponseBody
    @RequestMapping(value = "/SelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request) {
        System.out.println("sss");
        int count = iWorkService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/SelectCountClass", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCountClass(HttpServletRequest request) {
        String calssNameString=request.getParameter("className");
        Work aaa=new Work();
        aaa.setClassName(calssNameString);
        int count = iWorkService.SelectCountClass(aaa);
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/selectAll", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception   //显示homework表中所有作业的信息
    {
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageInteger +" "+ limitInteger);
        List<Work> listsList = iWorkService.selectAll(pageInteger,limitInteger);
        String[] colums = { "name", "className","data" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        return data;
    }

    @ResponseBody
    @RequestMapping(value="/selectClass", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectClass(HttpServletRequest request) throws Exception   //显示homework表中自己班级的作业信息
    {
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        String classNameString=request.getParameter("className");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        Integer Index=(pageInteger-1)*limitInteger;  //从第几条数据开始
        System.out.println(pageInteger +" "+ limitInteger+" "+classNameString);
        Map<String,Object> params=new HashMap<String, Object>();
        //以name字段升序排序，
        //params.put("sort", "name");
        //params.put("dir", "asc");
        //查询结果从第start条开始，查询limit条记录
        params.put("start", Index);
        params.put("limit", limitInteger);
        //查询班级名为title的数据
        params.put("title", classNameString);
        //分页查询作业信息
        List<Work> listsList = iWorkService.selectClass(params);
        String[] colums = { "name", "className","data" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        return data;
    }

}
