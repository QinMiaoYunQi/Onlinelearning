package com.javen.service;

import com.javen.model.Student;
import com.javen.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IStudentService {
    public List<Student> selectAll(int pageIndex, int pageSize);

    public Student selectById(int id);

    public int delete(Integer id);

    public int insert(Student student);

    public int update(Student student);

    public List<Student> likeByPhone(@Param("value") String value, int pageIndex, int pageSize);
    public Student selectByPhone(@Param("phone") String phone);

    int SelectCount();
}
