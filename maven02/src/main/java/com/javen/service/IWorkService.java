package com.javen.service;

import com.javen.model.Work;

import java.util.List;

public interface IWorkService {
    Integer SelectCount();

    List<Work> selectAll(Integer pageInteger, Integer limitInteger);
}
