package com.javen.service.impl;

import com.javen.dao.TeacherDao;
import com.javen.dao.WorkDao;
import com.javen.model.Correct;
import com.javen.model.Work;
import com.javen.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IWorkServiceImpl implements IWorkService {
    @Autowired
    private WorkDao workDao;

    public Integer SelectCount() {
        return this.workDao.SelectCount();
    }

    public List<Work> selectAll(Integer pageInteger, Integer limitInteger) {
        int Index = (pageInteger-1) * limitInteger;
        int Size = limitInteger;
        return this.workDao.selectAll(Index, Size);
    }

    public List<Work> selectClass(Map<String, Object> params) {
        return this.workDao.selectClass(params);
    }

    public Integer SelectCountClass(Work className) {
        return this.workDao.SelectCountClass(className);
    }

    public Integer insert(Correct correct) {
        return this.workDao.insert(correct);
    }
}
