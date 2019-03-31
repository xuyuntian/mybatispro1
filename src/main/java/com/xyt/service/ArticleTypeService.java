package com.xyt.service;

import com.xyt.entity.ArticleType;
import com.xyt.entity.TypeFolder;
import com.xyt.mapper.ArticleTypeMapper;
import com.xyt.mapper.TypeFolderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;
    @Autowired
    private TypeFolderMapper typeFolderMapper;
    public Integer addArticleType(ArticleType articleType){
        return articleTypeMapper.insertArticleType(articleType);
    }
    public void updateArticleType(ArticleType articleType){
        articleTypeMapper.updateArticleType(articleType);
    }

    /**
     *
     * @param id 删除的类型id,若该类型没有子目录，那么就可以删除
     * @return 是否成功
     */
    public boolean deleteArticleType(Integer id){
        List<TypeFolder> typeFolders = typeFolderMapper.selectTypeFolderMapperByParentId(id);
        if(typeFolders.size()>0){
            return false;
        }
        articleTypeMapper.deleteArticleTypeById(id);
        return  true;
    }
    public List<ArticleType> getArticleType(){
        return articleTypeMapper.selectArticleType();
    }
}
