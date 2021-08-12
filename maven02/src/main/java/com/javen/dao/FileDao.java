package com.javen.dao;

import com.javen.model.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileDao {
    public int insert(File file);

    public List<File> show(String className);
    public List<File> likeByFileName(@Param("value") String value, int pageIndex, int pageSize);
}
