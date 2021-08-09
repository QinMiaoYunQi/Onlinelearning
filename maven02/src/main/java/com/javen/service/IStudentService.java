package com.javen.service;

import com.javen.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentService {
    int GetCountStudent();

    List<Student> selectAll(int pageIndex,int pageSize);

    Integer insert(Student student);

    Integer delete(Integer id);

    Integer update(Student student);

    List<Student> likeByName(@Param("value") String value, int pageIndex, int pageSize);   //查询
}
