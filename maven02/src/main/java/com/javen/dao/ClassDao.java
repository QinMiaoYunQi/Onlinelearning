package com.javen.dao;

import com.javen.model.ClassXX;

import java.util.List;

public interface ClassDao {
    public List<ClassXX> selectAll(int pageIndex, int pageSize);

    public ClassXX selectById(int id);

    public int delete(Integer id);

    public int insert(ClassXX cla);

    public int update(ClassXX cla);




    int SelectCount();
}
