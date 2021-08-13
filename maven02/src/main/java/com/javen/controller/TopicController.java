package com.javen.controller;



import com.javen.model.Topic;
import com.javen.service.ITopicService;
import com.javen.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private ITopicService iTopicService;
    @ResponseBody
    @RequestMapping(value = "/SelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request) {
        int count = iTopicService.SelectCount();
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
        List<Topic> listsList = iTopicService.selectAll(pageInteger,limitInteger);
        String[] colums = { "id", "title", "heat","foundTime","studentName" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        System.out.println(data);
        return data;
    }
    @ResponseBody
    @RequestMapping(value="/selectById", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectById(HttpServletRequest request) throws Exception{
        String  idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        System.out.println("id:"+idInteger);
        Topic topic = iTopicService.selectById(idInteger);
        System.out.println(topic.toString());
        String[] colums = {"id","title","heat","foundTime","studentName"};
        String data = ObjtoLayJson.toJson(topic, colums);
        System.out.println(data);
        return data;
    }
    @ResponseBody
    @RequestMapping(value="/heat", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String heat(HttpServletRequest request){
        String title = request.getParameter("title");
        int count = iTopicService.heat(title);
        String json = "";
        if (count==1){
            json= "{"+"\"count\":\"成功\"}";
        }else {
            json= "{"+"\"count\":\"失败\"}";
        }
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request){
        String title = request.getParameter("title");
        String studentName = request.getParameter("studentName");
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setStudentName(studentName);
        topic.setFoundTime(new Date());
        topic.setHeat(0);
        int count = iTopicService.insert(topic);
        String json = "";
        if (count==1){
            json= "{"+"\"count\":\"成功\"}";
        }else {
            json= "{"+"\"count\":\"失败\"}";
        }
        return json;

    }
}
