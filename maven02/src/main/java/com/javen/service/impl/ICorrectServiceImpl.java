package com.javen.service.impl;

import com.javen.dao.CorrectDao;
import com.javen.dao.TeacherDao;
import com.javen.model.Correct;
import com.javen.service.ICorrectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ICorrectServiceImpl implements ICorrectService {
    @Autowired
    private CorrectDao correctDao;

    public Integer SelectCount() {
        return this.correctDao.SelectCount();
    }

    public List<Correct> selectAll(Map<String, Object> params) {
        return this.correctDao.selectAll(params);
    }

    public Integer update(Correct correct) {
        return this.correctDao.update(correct);
    }


}
