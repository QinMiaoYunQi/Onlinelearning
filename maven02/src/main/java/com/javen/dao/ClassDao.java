package com.javen.dao;

import com.javen.model.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassDao {
    public List<com.javen.model.Class> selectAll(int pageIndex, int pageSize);

    public com.javen.model.Class selectById(int id);

    public int delete(Integer id);

    public int insert(com.javen.model.Class cla);

    public int update(com.javen.model.Class cla);



    int SelectCount();
}
