package com.javen.service;

import com.javen.model.Correct;

import java.util.List;
import java.util.Map;

public interface ICorrectService {
    Integer SelectCount();

    List<Correct> selectAll(Map<String, Object> params);

    Integer update(Correct correct);
}
