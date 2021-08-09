package com.javen.dao;

import com.javen.model.Student;
import com.javen.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    int SelectCount();

    List<Teacher> selectAll(int index, int size);

    Integer insert(Teacher teacher);

    Integer delete(Integer id);

    Integer update(Teacher teacher);

    List<Teacher> likeByName(@Param("value") String value, Integer pageIndex, Integer pageSize);
}
