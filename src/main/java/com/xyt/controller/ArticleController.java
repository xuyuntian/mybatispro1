package com.xyt.controller;

import com.xyt.annotation.CheckToken;
import com.xyt.authorization.ModifyState;
import com.xyt.authorization.RequestBodyData;
import com.xyt.entity.Article;
import com.xyt.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 1代表操作成功
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/get-articles-by-folder")
    public List<Article> getArticlesByFolder(Integer id){
        return articleService.getArtilcListByFolder(id);
    }

    @PutMapping("/update-article")
    @CheckToken
    public Integer  updateArticle(@RequestBody RequestBodyData<Article> requestBodyData){
        articleService.updateArticle(requestBodyData.getPostData());
        return ModifyState.SUCCESS;
    }

    @DeleteMapping("/delete-artilce")
    @CheckToken
    public Integer deleteArticle(@RequestBody RequestBodyData<Integer> requestBodyData){
        articleService.removeArticle(requestBodyData.getPostData());
        return ModifyState.SUCCESS;
    }

    @PostMapping("/add-article")
    @CheckToken
    public Integer addArtilce(@RequestBody RequestBodyData<Article> requestBodyData){
        return articleService.addArticle(requestBodyData.getPostData()) ? ModifyState.SUCCESS : ModifyState.FAILD;
    }
}
