package com.javen.service;

import com.javen.model.Leave;

import java.util.List;

public interface ILeaveService {
    int SelectCount();

    List<Leave> selectAll(Integer pageInteger, Integer limitInteger);

    List<Leave> thisMonth(Integer pageInteger, Integer limitInteger);

    int update(Leave leave);

    List<Leave> selectLimit(Leave leave);

    List<Leave> selectPhone(Leave leave);

    int insert(Leave leave);
}
