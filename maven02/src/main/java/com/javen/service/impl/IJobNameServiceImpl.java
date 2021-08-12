package com.javen.service.impl;

import com.javen.dao.JobNameDao;
import com.javen.model.JobName;
import com.javen.service.IJobNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IJobNameServiceImpl implements IJobNameService {
    @Autowired
    private JobNameDao jobNameDao;

    public int SelectCount() {
        return this.jobNameDao.SelectCount();
    }

    public List<JobName> selectAll(Map map){
        return this.jobNameDao.selectAll(map);
    }

    public int update(JobName jobName){
        return this.jobNameDao.update(jobName);
    };
    public int doJob(JobName jobName){
        return this.jobNameDao.doJob(jobName);
    };
}
