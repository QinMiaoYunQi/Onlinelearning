package com.javen.service;

import com.javen.model.Student;
import com.javen.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITeacherService {
    int SelectCount();

    List<Teacher> selectAll(int pageInteger, int limitInteger);

    Integer insert(Teacher teacher);

    Integer delete(Integer idInteger);

    Integer update(Teacher teacher);

    List<Teacher> likeByName(@Param("value") String value, Integer pageIndex, Integer pageSize);

    List<Teacher> GetTeacher(String classNameString);

    Integer SelectNullClass(String classNameString);

    Integer updateClass(Teacher teacher);
}
