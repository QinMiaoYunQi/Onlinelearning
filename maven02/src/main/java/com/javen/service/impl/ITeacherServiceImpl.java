package com.javen.service.impl;

import com.javen.dao.TeacherDao;
import com.javen.model.Student;
import com.javen.model.Teacher;
import com.javen.service.ITeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITeacherServiceImpl implements ITeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public int SelectCount() {
        return this.teacherDao.SelectCount();
    }

    public List<Teacher> selectAll(int pageInteger, int limitInteger) {
        int Index = (pageInteger-1) * limitInteger;
        int Size = limitInteger;
        return this.teacherDao.selectAll(Index, Size);
    }

    public Integer insert(Teacher teacher) {
        return this.teacherDao.insert(teacher);
    }

    public Integer delete(Integer idInteger) {
        return this.teacherDao.delete(idInteger);
    }

    public Integer update(Teacher teacher) {
        return this.teacherDao.update(teacher);
    }

    public List<Teacher> likeByName(String value, Integer pageInteger, Integer limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.teacherDao.likeByName(value,pageIndex,pageSize);
    }

    public List<Teacher> GetTeacher(String classNameString) {
        return this.teacherDao.GetTeacher(classNameString);
    }

    public Integer SelectNullClass(String classNameString) {
        return this.teacherDao.SelectNullClass(classNameString);
    }

    public Integer updateClass(Teacher teacher) {
        return this.teacherDao.updateClass(teacher);
    }
}
