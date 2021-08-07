package com.javen.service.impl;

import com.javen.dao.StudentDao;
import com.javen.model.Student;
import com.javen.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private StudentDao StudentDao;
    public List<Student> selectAll(int pageInteger, int limitInteger){
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.StudentDao.selectAll(pageIndex, pageSize);
    }




    public Student selectById(int id){
        return this.StudentDao.selectById(id);
    }

    public int delete(Integer id) {
        return this.StudentDao.delete(id);
    }

    public int insert(Student student) {
        return this.StudentDao.insert(student);
    }

    public int update(Student student) {
        return this.StudentDao.update(student);
    }

    public List<Student> likeByName(String value) {
        return this.StudentDao.likeByName(value);
    }


    public int SelectCount() {
        // TODO Auto-generated method stub
        return this.StudentDao.SelectCount();
    }

}
