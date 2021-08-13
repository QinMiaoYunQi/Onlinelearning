package com.javen.service.impl;

import com.javen.dao.ClassDao;
import com.javen.model.ClassXX;
import com.javen.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IClassServiceImpl implements IClassService {

    @Autowired
    private ClassDao ClassDao;
    public List<ClassXX> selectAll(int pageInteger, int limitInteger){
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.ClassDao.selectAll(pageIndex, pageSize);
    }




    public ClassXX selectById(int id){
        return this.ClassDao.selectById(id);
    }

    public int delete(Integer id) {
        return this.ClassDao.delete(id);
    }

    public int insert(ClassXX cla) {
        return this.ClassDao.insert(cla);
    }

    public int update(ClassXX cla) {
        return this.ClassDao.update(cla);
    }


    public int SelectCount() {
        return this.ClassDao.SelectCount();
    }


}
