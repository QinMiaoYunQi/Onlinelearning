package com.javen.service.impl;

import com.javen.dao.TitleDao;
import com.javen.model.Title;
import com.javen.service.ITitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITitleServiceImpl implements ITitleService {
    @Autowired
    private TitleDao titleDao;

    public List<Title> selectByTitle(String title) {
        return this.titleDao.selectByTitle(title);
    }

    public int insert(Title title1) {
        return this.titleDao.insert(title1);
    }
}
