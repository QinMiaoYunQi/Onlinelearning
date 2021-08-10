package com.javen.service;

import com.javen.model.Title;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITitleService {
    public List<Title> selectByTitle(@Param("title") String title);
    int insert(Title title1);
}
