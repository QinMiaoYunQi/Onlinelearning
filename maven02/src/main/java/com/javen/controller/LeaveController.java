package com.javen.controller;

import com.alibaba.fastjson.JSONObject;
import com.javen.model.Leave;
import com.javen.model.Student;
import com.javen.model.Teacher;
import com.javen.service.ILeaveService;
import com.javen.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private ILeaveService iLeaveService;

    @ResponseBody
    @RequestMapping(value = "/SelectCount",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request)
    {
        int count=iLeaveService.SelectCount();
        System.out.println("count: "+count);
        String data=String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/selectAll", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception   //显示请假表中所有请假的信息
    {
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageInteger +" "+ limitInteger);
        List<Leave> listsList = iLeaveService.selectAll(pageInteger,limitInteger);
        String[] colums = { "id", "name", "phone","data", "reason","result" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        System.out.println(data);
        return data;
    }

    @ResponseBody
    @RequestMapping(value="/selectLimit", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectLimit(HttpServletRequest request) throws Exception   //显示请假表中所有请假的信息
    {
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        String resultString="待管理员审批";
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageInteger +" "+ limitInteger+" "+resultString);
        Leave aaa=new Leave();
        aaa.setResult(resultString);
        List<Leave> listsList = iLeaveService.selectLimit(aaa);
        String[] colums = { "id", "name", "phone","data", "reason","result" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        System.out.println(data);
        return data;
    }

    @ResponseBody
    @RequestMapping(value="agree", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String update(HttpServletRequest request)     //管理员同意请假功能
    {
        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        String resultString = request.getParameter("result");
        System.out.println(idInteger+" "+resultString);
        System.out.println("...............");
        Leave leave = new Leave();
        leave.setId(idInteger);
        leave.setResult(resultString);
        int count = iLeaveService.update(leave);
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
    @RequestMapping(value="/selectPhone", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectPhone(HttpServletRequest request) throws Exception   //教师端查看自己的请假信息
    {
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        String phoneString=request.getParameter("phone");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageInteger +" "+ limitInteger+" 电话："+phoneString);
        Leave aaa=new Leave();
        aaa.setPhone(phoneString);
        List<Leave> listsList = iLeaveService.selectPhone(aaa);
        String[] colums = { "id", "name", "phone","data", "reason","result" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        System.out.println(data);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/insertLeave",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insertLeave(HttpServletRequest request)   //插入请假信息
    {
        String nameString=request.getParameter("name");
        String phoneString=request.getParameter("phone");
        String dataString = request.getParameter("data");
        String reasonString = request.getParameter("reason");
        String resultString="待管理员审批";
        System.out.println(nameString+" "+phoneString+" "+dataString+" "+reasonString+" "+resultString);
        System.out.println("-------------------------");
        Leave leave = new Leave();
        leave.setName(nameString);
        leave.setPhone(phoneString);
        leave.setData(dataString);
        leave.setReason(reasonString);
        leave.setResult(resultString);
        int count = iLeaveService.insert(leave);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"添加失败\"}";
        }else{
            json="{\"count\":\"200\",\"message\":\"添加成功\"}";
        }
        System.out.println(json);
        return json;
    }




}
