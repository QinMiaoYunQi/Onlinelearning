package com.javen.service;

import java.lang.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IClassService {
    public List<com.javen.model.Class> selectAll(int pageIndex, int pageSize);

    public com.javen.model.Class selectById(int id);

    public int delete(Integer id);

    public int insert(com.javen.model.Class cla);

    public int update(com.javen.model.Class cla);



    int SelectCount();
}
