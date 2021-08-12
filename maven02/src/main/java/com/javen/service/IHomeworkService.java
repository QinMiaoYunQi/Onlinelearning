package com.javen.service;

import com.javen.model.Homework;

import java.util.List;
import java.util.Map;

public interface IHomeworkService {
    int SelectCount();
    public List<Homework> selectAll(Map map);
}
