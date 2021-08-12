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
    @RequestMapping(value="/selectAll", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception{
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString +" "+ limitString);
        List<Student> listsList = iStudentService.selectAll(pageInteger,limitInteger);
        String[] colums = { "id", "name", "phone","password", "className" };
        String data = ObjtoLayJson.ListtoJson(listsList, colums);
        return data;
    }
    @ResponseBody
    @RequestMapping(value = "/SelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request) {
        int count = iStudentService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }



    @ResponseBody
    @RequestMapping(value = "/selectById", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public Student selectById(HttpServletRequest request){
        String id = request.getParameter("id");
        Integer idInteger = Integer.valueOf(id);
        Student student = iStudentService.selectById(idInteger);
        return student;
    }

    @ResponseBody
    @RequestMapping(value="insert", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request){
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String className = request.getParameter("className");
        System.out.println(name+" "+phone+" "+password+" "+className);
        System.out.println("-------------------------");
        Student student = new Student();
        student.setName(name);
        student.setPhone(phone);
        student.setPassword(password);
        student.setClassName(className);
        int count = iStudentService.insert(student);
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
        String id = request.getParameter("id");
        Integer idInteger = Integer.valueOf(id);
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String className = request.getParameter("className");
        System.out.println(id+" "+name+" "+phone+" "+password+" "+className);
        System.out.println("...............");
        Student student = new Student();
        student.setId(idInteger);
        student.setName(name);
        student.setPhone(phone);
        student.setPassword(password);
        student.setClassName(className);
        int count = iStudentService.update(student);
        String json="";
        if(count==0) {
            json="{\"count\":\"200\",\"message\":\"修改失败\"}";
        }else{json="{\"count\":\"200\",\"message\":\"修改成功\"}";}
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/likeByPhone", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String likeByPhone(HttpServletRequest request) throws Exception {
        String phone = request.getParameter("phone");
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString +" "+ limitString);
        System.out.println("phone:"+phone);
        List<Student> students = iStudentService.likeByPhone(phone,pageInteger,limitInteger);
        for (Student student : students) {
            System.out.println(student.toString());
        }
        String[] colums = { "id", "name", "phone","password", "className" };
        String data = ObjtoLayJson.ListtoJson(students, colums);
        System.out.println(data);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/selectByPhone", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectByPhone(HttpServletRequest request) throws Exception {
        String phone = request.getParameter("phone");
        System.out.println("phone:"+phone);
        Student student = iStudentService.selectByPhone(phone);
        String[] colums = { "id", "name", "phone","password", "className" };
        String data = ObjtoLayJson.toJson(student, colums);
        System.out.println(data);
        return data;
    }

}
