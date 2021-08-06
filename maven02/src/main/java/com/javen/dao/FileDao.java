package com.javen.dao;

import com.javen.model.File;

import java.util.List;

public interface FileDao {
    public int insert(File file);

    public List<File> show();
}
