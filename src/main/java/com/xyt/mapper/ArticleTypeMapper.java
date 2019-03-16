package com.xyt.mapper;

import com.xyt.entity.ArticleType;

import java.util.List;

public interface ArticleTypeMapper {
    void insertArticleType(ArticleType articleType);
    void updateArticleType(ArticleType articleType);
    List<ArticleType> selectArticleType();
    void deleteArticleTypeById(Integer id);
}
