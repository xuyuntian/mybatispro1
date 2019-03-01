package com.xyt.mapper;

import com.xyt.model.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

public interface ArticleMapper {
   List<Article> getArticleByAuthorId(Integer authorId);
   void insertArticle(Article article);
   void updateArticle(Integer id, String content, String title, Date modifyDate);
   void deleteArticle(Integer id);
   void insertArticleToHistory(Article article,Date deleteDate);
   Article getArticleById(Integer id);

}
