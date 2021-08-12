package com.javen.service.impl;

import com.javen.dao.HomeworkDao;
import com.javen.model.Homework;
import com.javen.service.IHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IHomeworkServiceImpl implements IHomeworkService {
    @Autowired
    private HomeworkDao homeworkDao;

    public int SelectCount() {
        return this.homeworkDao.SelectCount();
    }

    public List<Homework> selectAll(Map map){
        return this.homeworkDao.selectAll(map);
    }

}
