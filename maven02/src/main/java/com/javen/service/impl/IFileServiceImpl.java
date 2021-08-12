package com.javen.service.impl;

import com.javen.dao.FileDao;
import com.javen.model.File;
import com.javen.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFileServiceImpl implements IFileService {

    @Autowired
    private FileDao fileDao;

    public int insert(File file) {
        return this.fileDao.insert(file);
    }

    public List<File> show(String className) {
        return this.fileDao.show(className);
    }
    public List<File> likeByFileName(String value, int pageInteger, int limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.fileDao.likeByFileName(value,pageIndex,pageSize);
    }

}
