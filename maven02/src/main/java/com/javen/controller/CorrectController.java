package com.javen.controller;


import com.javen.model.Correct;
import com.javen.model.Teacher;
import com.javen.service.ICorrectService;

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
@RequestMapping("/correct")
public class CorrectController {
    @Autowired
    private ICorrectService iCorrectService;

    @ResponseBody
    @RequestMapping(value = "/SelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request) {
        int count = iCorrectService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/selectAll", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception   //显示学生表中所有学生的信息
    {
        String pageString = request.getParameter("page");  //页数
        String limitString = request.getParameter("limit"); //限制查询条数
        String workNameString=request.getParameter("workName");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        Integer Index=(pageInteger-1)*limitInteger;  //从第几条数据开始
        System.out.println(pageInteger +" "+ limitInteger+" "+workNameString);
        Map<String,Object> params=new HashMap<String, Object>();
        //以name字段升序排序，
        //params.put("sort", "name");
        //params.put("dir", "asc");
        //查询结果从第start条开始，查询limit条记录
        params.put("start", Index);
        params.put("limit", limitInteger);
        //查询作业名为title的数据
        params.put("title", workNameString);
        //分页查询教师信息
        List<Correct> listsList = iCorrectService.selectAll(params);
        String[] colums = { "id", "workName", "studentName","content", "point" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        return data;
    }

    @ResponseBody
    @RequestMapping(value="update", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String update(HttpServletRequest request)     //修改功能
    {
        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        String pointString = request.getParameter("point");
        System.out.println(idInteger+" "+pointString);
        System.out.println("...............");
        Correct correct = new Correct();
        correct.setId(idInteger);
        correct.setPoint(pointString);
        int count = iCorrectService.update(correct);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"评分失败\"}";
        }else {
            json="{\"count\":\"200\",\"message\":\"评分成功\"}";
        }
        System.out.println(json);
        return json;
    }
}
