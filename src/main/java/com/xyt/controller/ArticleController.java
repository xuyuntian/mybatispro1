package com.xyt.controller;

import com.xyt.annotation.CheckDelete;
import com.xyt.annotation.CheckModified;
import com.xyt.authorization.ModifyState;
import com.xyt.authorization.RequestBodyData;
import com.xyt.entity.Article;
import com.xyt.entity.MyUser;
import com.xyt.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 1代表操作成功
 */
@CrossOrigin
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/get-articles-by-folder")
    public List<Article> getArticlesByFolder(Integer id){
        return articleService.getArtilcListByFolder(id);
    }
    @GetMapping("/get-article-by-id")
    public Article getArticleById(Integer id){
        return articleService.getArticleById(id);
    }
    @PutMapping("/update-article")
    @CheckModified
    public Integer  updateArticle(@RequestBody RequestBodyData<Article> requestBodyData){
        articleService.updateArticle(requestBodyData.getPostData());
        return ModifyState.SUCCESS;
    }

    @DeleteMapping("/delete-article")
    @CheckDelete
    public Integer deleteArticle(String email,String type,Integer id,String token){
        articleService.removeArticle(id);
        return ModifyState.SUCCESS;
    }

    @PostMapping("/add-article")
    @CheckModified
    public Integer addArtilce(@RequestBody RequestBodyData<Article> requestBodyData){
        Article article = requestBodyData.getPostData();
        articleService.addArticle(article);
        return article.getId();
    }
}
