package com.javen.service.impl;

import com.javen.dao.TeacherDao;
import com.javen.model.Teacher;
import com.javen.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherDao teacherDao;
    public List<Teacher> selectAll(int pageInteger, int limitInteger){
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.teacherDao.selectAll(pageIndex, pageSize);
    }




    public Teacher selectById(int id){
        return this.teacherDao.selectById(id);
    }

    public int delete(Integer id) {
        return this.teacherDao.delete(id);
    }

    public int insert(Teacher teacher) {
        return this.teacherDao.insert(teacher);
    }

    public int update(Teacher teacher) {
        return this.teacherDao.update(teacher);
    }

    public List<Teacher> likeByName(String value) {
        return this.teacherDao.likeByName(value);
    }


    public int SelectCount() {
        // TODO Auto-generated method stub
        return this.teacherDao.SelectCount();
    }

}
