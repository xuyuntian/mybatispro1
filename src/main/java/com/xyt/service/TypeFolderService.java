package com.xyt.service;

import com.xyt.entity.Article;
import com.xyt.entity.TypeFolder;
import com.xyt.mapper.ArticleMapper;
import com.xyt.mapper.TypeFolderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

public class TypeFolderService {
    @Autowired
    private TypeFolderMapper typeFolderMapper;
    @Autowired
    private ArticleMapper articleMapper;
    public List<TypeFolder> getTypeFolderByType(Integer id){
        return typeFolderMapper.selectTypeFolderMapperByParentId(id);
    }
    /**
     *
     * @param id TypeFolder的id
     * @return  如果该目录下没有文章，则可以删除，否则不能删。
     * 删除成功返回true.失败返回false
     */
    public  boolean deleetTypeFolder(Integer id){
        List<Article> articles = articleMapper.selectArticlesByParentId(id);
        if(articles==null){
            typeFolderMapper.deleteTypeFolderById(id);
        }
        return false;
    }

    /**
     *
     * @param typeFolder 要添加的TypeFolder. 但相同类别的目录name不能重复
     * @return 是否添加成功
     */
    public boolean addTypeFolder(TypeFolder typeFolder){
        List<TypeFolder> typeFolders = typeFolderMapper.selectTypeFolderMapperByParentId(typeFolder.getParentId());
        HashSet<String> hashSet = new HashSet<>();
        for(TypeFolder e : typeFolders){
            hashSet.add(e.getName());
        }
        if(hashSet.contains(typeFolder.getName())){
            return false;
        }
        typeFolderMapper.insertTypeFolder(typeFolder);
        return true;
    }
    public boolean updateTypeFolder(TypeFolder typeFolder){
        List<TypeFolder> typeFolders = typeFolderMapper.selectTypeFolderMapperByParentId(typeFolder.getParentId());
        HashSet<String> hashSet = new HashSet<>();
        for(TypeFolder e : typeFolders){
            hashSet.add(e.getName());
        }
        if(hashSet.contains(typeFolder.getName())){
            return false;
        }
        typeFolderMapper.updateTypeFolder(typeFolder);
        return true;
    }
}
