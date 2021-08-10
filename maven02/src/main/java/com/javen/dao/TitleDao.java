package com.javen.dao;

import com.javen.model.Title;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleDao {
    public List<Title> selectByTitle(@Param("title") String title);
    int insert(Title title1);
}
