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
    private StudentDao studentDao;

    public int GetCountStudent() {
        return this.studentDao.GetCountStudent();
    }

    public List<Student> selectAll(int pageIndex, int pageSize) {
        int Index = (pageIndex-1) * pageSize;
        int Size = pageSize;
        return this.studentDao.selectAll(Index, Size);
    }

    public Integer insert(Student student) {
        return this.studentDao.insert(student);
    }

    public Integer delete(Integer id) {
        return this.studentDao.delete(id);
    }

    public Integer update(Student student) {
        return this.studentDao.update(student);
    }

    public List<Student> likeByName(String value, int pageInteger, int limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.studentDao.likeByName(value,pageIndex,pageSize);
    }
}
