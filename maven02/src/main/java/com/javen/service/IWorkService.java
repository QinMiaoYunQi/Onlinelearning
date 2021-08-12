package com.javen.service;

import com.javen.model.Work;

import java.util.List;
import java.util.Map;

public interface IWorkService {
    Integer SelectCount();

    List<Work> selectAll(Integer pageInteger, Integer limitInteger);

    List<Work> selectClass(Map<String, Object> params);

    Integer SelectCountClass(Work className);
}
