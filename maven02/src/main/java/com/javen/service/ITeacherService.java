package com.javen.service;

import com.javen.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;




public interface ITeacherService {
    public List<Teacher> selectAll(int pageIndex, int pageSize);

    public Teacher selectById(int id);

    public int delete(Integer id);

    public int insert(Teacher teacher);

    public int update(Teacher teacher);

    public List<Teacher> likeByName(@Param("value") String value, int pageIndex, int pageSize);

    int getCount(String name);

    int SelectCount();
}
