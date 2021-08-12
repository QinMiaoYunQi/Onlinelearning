package com.javen.service;

import com.javen.model.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IFileService {
    public int insert(File file);

    public List<File> show();

    public List<File> likeByFileName(@Param("value") String value, int pageIndex, int pageSize);
}
