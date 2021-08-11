package com.javen.dao;

import com.javen.model.Work;

import java.util.List;

public interface WorkDao {
    Integer SelectCount();

    List<Work> selectAll(int index, int size);
}
