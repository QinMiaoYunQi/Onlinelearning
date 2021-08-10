package com.javen.service;

import com.javen.model.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITopicService {
    int SelectCount();
    public List<Topic> selectAll(int pageIndex, int pageSize);
    public Topic selectById(int id);
    public int heat(@Param("title") String title);
}
