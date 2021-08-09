package com.javen.controller;

import com.javen.model.Student;
import com.javen.service.IStudentService;
import com.javen.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @ResponseBody
    @RequestMapping(value = "/GetCountStudent", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String GetCountStudent(HttpServletRequest request)   //获取学生表中所有的数据条数
    {
        int count = iStudentService.GetCountStudent();
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
        List<Student> listsList = iStudentService.selectAll(pageInteger,limitInteger);
        String[] colums = { "id", "name", "phone","password", "className" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        return data;
    }

    @ResponseBody
    @RequestMapping(value="insert", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request)    //添加学生信息
    {
        String nameString = request.getParameter("name");
        String phoneString = request.getParameter("phone");
        String passwordString = request.getParameter("password");
        String classNameString = request.getParameter("className");
        System.out.println(nameString+" "+phoneString+" "+passwordString+" "+classNameString);
        System.out.println("-------------------------");
        Student student = new Student();
        student.setName(nameString);
        student.setPhone(phoneString);
        student.setPassword(passwordString);
        student.setClassName(classNameString);
        int count = iStudentService.insert(student);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"添加失败\"}";
        }else{
            json="{\"count\":\"200\",\"message\":\"添加成功\"}";
        }
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value="delete", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String delete(HttpServletRequest request){
        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        System.out.println("id: "+idInteger);
        int count = iStudentService.delete(idInteger);
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
        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        String nameString = request.getParameter("name");
        String phoneString = request.getParameter("phone");
        String passwordString = request.getParameter("password");
        String classNameString = request.getParameter("className");
        System.out.println(idInteger+" "+nameString+" "+phoneString+" "+passwordString+" "+classNameString);
        System.out.println("...............");
        Student student = new Student();
        student.setId(idInteger);
        student.setName(nameString);
        student.setPhone(phoneString);
        student.setPassword(passwordString);
        student.setClassName(classNameString);
        int count = iStudentService.update(student);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"修改失败\"}";
        }else {
            json="{\"count\":\"200\",\"message\":\"修改成功\"}";
        }
        System.out.println(json);
        return json;
    }
}
