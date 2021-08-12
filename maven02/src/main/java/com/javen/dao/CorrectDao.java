package com.javen.dao;

import com.javen.model.Correct;

import java.util.List;
import java.util.Map;

public interface CorrectDao {
    Integer SelectCount();

    List<Correct> selectAll(Map<String, Object> params);

    Integer update(Correct correct);

    Integer insert(Correct correct);
}
