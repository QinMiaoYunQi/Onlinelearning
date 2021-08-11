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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @RequestMapping(value="/selectAll", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception   //显示学生表中所有学生的信息
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
}
