package com.xyt.service;

import com.xyt.entity.Article;
import com.xyt.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    public List<Article> getArtilcListByFolder(Integer id){
        return articleMapper.selectArticlesByParentId(id);
    }
    public void removeArticle(Integer id){
        articleMapper.deleteArticleById(id);
    }
    public void updateArticle(Article article){
        articleMapper.updateArticle(article);
    }

    /**
     *
     * @param article 要插入的数据
     *                同一个目录下的文章id不能重复
     * @return 返回是否成功?true:false;
     */
    public Integer addArticle(Article article){
        return articleMapper.insertArticle(article);
    }
    public Article getArticleById(Integer id){
        return articleMapper.selectArticleById(id);
    }
}
