package com.xyt.mapper;

import com.xyt.entity.Article;

import java.util.List;

public interface ArticleMapper {
    void insertArticle(Article article);
    void updateArticle(Article article);
    void deleteArticleById(Integer id);
    Article selectArticleById(Integer id);
    List<Article> selectArticlesByParentId(Integer parentId);
}
