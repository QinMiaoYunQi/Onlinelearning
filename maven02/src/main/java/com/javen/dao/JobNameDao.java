package com.javen.dao;

import com.javen.model.JobName;

import java.util.List;
import java.util.Map;

public interface JobNameDao {
    int SelectCount();
    public List<JobName> selectAll(Map map);
    int update(JobName jobName);
    int doJob(JobName jobName);
}
