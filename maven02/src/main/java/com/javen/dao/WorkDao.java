package com.javen.dao;

import com.javen.model.Correct;
import com.javen.model.Work;

import java.util.List;
import java.util.Map;

public interface WorkDao {
    Integer SelectCount();

    List<Work> selectAll(int index, int size);

    List<Work> selectClass(Map<String, Object> params);

    Integer SelectCountClass(Work className);

    Integer insert(Correct correct);
}
