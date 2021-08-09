package com.javen.service;

import com.javen.model.Leave;

import java.util.List;

public interface ILeaveService {
    int SelectCount();

    List<Leave> selectAll(Integer pageInteger, Integer limitInteger);

    int update(Leave leave);

    List<Leave> selectLimit(Leave leave);
}
