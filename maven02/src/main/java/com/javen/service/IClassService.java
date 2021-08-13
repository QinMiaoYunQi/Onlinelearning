package com.javen.service;

import com.javen.model.ClassXX;

import java.util.List;


public interface IClassService {
    public List<ClassXX> selectAll(int pageIndex, int pageSize);

    public ClassXX selectById(int id);

    public int delete(Integer id);

    public int insert(ClassXX cla);

    public int update(ClassXX cla);

    int SelectCount();
}
