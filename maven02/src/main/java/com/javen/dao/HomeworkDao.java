package com.javen.dao;

import com.javen.model.Homework;

import java.util.List;
import java.util.Map;

public interface HomeworkDao {
    int SelectCount();
    public List<Homework> selectAll(Map map);
    int insert(Homework homework);
}
