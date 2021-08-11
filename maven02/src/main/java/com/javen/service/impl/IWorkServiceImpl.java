package com.javen.service.impl;

import com.javen.dao.TeacherDao;
import com.javen.dao.WorkDao;
import com.javen.model.Work;
import com.javen.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
