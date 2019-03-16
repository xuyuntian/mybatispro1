package com.xyt.mapper;

import com.xyt.entity.TypeFolder;

import java.util.List;

public interface TypeFolderMapper {
    List<TypeFolder> selectTypeFolderMapperByParentId(Integer parentId);
    void updateTypeFolder(TypeFolder typeFolder);
    void insertTypeFolder(TypeFolder typeFolder);
    void deleteTypeFolderById(Integer id);
}
