package com.javen.service;

import com.javen.model.File;

import java.util.List;

public interface IFileService {
    public int insert(File file);

    public List<File> show();
}
