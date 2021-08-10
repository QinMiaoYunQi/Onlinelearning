package com.javen.dao;

import com.javen.model.Leave;

import java.util.List;

public interface LeaveDao {
    int SelectCount();

    List<Leave> selectAll(int index, int size);

    List<Leave> selectLimit(Leave leave);

    int update(Leave leave);

    List<Leave> selectPhone(Leave leave);

    Integer insert(Leave leave);
}
