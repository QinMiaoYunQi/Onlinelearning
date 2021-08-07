package com.javen.service;

import com.javen.model.Student;

import java.util.List;


public interface IStudentService {
    public List<Student> selectAll(int pageIndex, int pageSize);

    public Student selectById(int id);

    public int delete(Integer id);

    public int insert(Student student);

    public int update(Student student);

    public List<Student> likeByName(String value);


    int SelectCount();
}
