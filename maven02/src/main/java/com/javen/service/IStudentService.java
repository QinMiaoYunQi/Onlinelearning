package com.javen.service;

import com.javen.model.Student;

import java.util.List;

public interface IStudentService {
    int GetCountStudent();

    List<Student> selectAll(int pageIndex,int pageSize);

    Integer insert(Student student);

    Integer delete(Integer id);

    Integer update(Student student);
}
