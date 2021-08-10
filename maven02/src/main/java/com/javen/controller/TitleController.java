package com.javen.controller;


import com.javen.model.Login;
import com.javen.model.Title;
import com.javen.service.ITitleService;
import com.javen.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private ITitleService iTitleService;

    @ResponseBody
    @RequestMapping(value="/selectByTitle", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectByTitle(HttpServletRequest request) throws Exception {
        String title = request.getParameter("title");
        System.out.println(title);
        List<Title> list = iTitleService.selectByTitle(title);
        System.out.println("-------------------");
        String[] colums = {"id","comment","title","studentName"};
        String data = ObjtoLayJson.ListtoJson(list, colums);
        System.out.println(data);
        return data;
    }
    @ResponseBody
    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request) {
        //插入数据库
        String comment = request.getParameter("comment");
        String title = request.getParameter("title");
        String studentName = request.getParameter("studentName");
        System.out.println(comment+" "+title+" "+studentName);
        Title title1 = new Title();
        title1.setComment(comment);
        title1.setTitle(title);
        title1.setStudentName(studentName);
        int count = iTitleService.insert(title1);

        String data = "";
        //给前台返回的东西
        if (count==1){
        data = "{\"data\":\"评论成功\"}";
        }
        return data;
    }

}
