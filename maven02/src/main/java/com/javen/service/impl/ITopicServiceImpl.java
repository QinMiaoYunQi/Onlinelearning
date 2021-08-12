package com.javen.service.impl;

import com.javen.dao.TopicDao;
import com.javen.model.Topic;
import com.javen.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITopicServiceImpl implements ITopicService {
    @Autowired
    private TopicDao topicDao;
    public int SelectCount() {
        // TODO Auto-generated method stub
        return this.topicDao.SelectCount();
    }
    public List<Topic> selectAll(int pageInteger, int limitInteger){
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.topicDao.selectAll(pageIndex, pageSize);
    }

    public Topic selectById(int id) {
        return this.topicDao.selectById(id);
    }

    public int heat(String title) {
        return this.topicDao.heat(title);
    }

    public int insert(Topic topic) {
        return this.topicDao.insert(topic);
    }

}
