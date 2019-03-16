package com.xyt.controller;

import com.xyt.annotation.CheckToken;
import com.xyt.authorization.ModifyState;
import com.xyt.authorization.RequestBodyData;
import com.xyt.entity.ArticleType;
import com.xyt.entity.TypeFolder;
import com.xyt.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;
    @GetMapping("get-article-type-list")
    public List<ArticleType> getArticleTypeList(){
        return articleTypeService.getArticleType();
    }
    @PostMapping("add-article-type")
    @CheckToken
    public Integer addArticleType(@RequestBody RequestBodyData<ArticleType> requestBodyData){
        ArticleType articleType =requestBodyData.getPostData();
        articleTypeService.addArticleType(articleType);
        return ModifyState.SUCCESS;
    }
    @DeleteMapping("delete-article-type")
    @CheckToken
    public Integer deleteArticleType(@RequestBody RequestBodyData<TypeFolder> requestBodyData){
        return articleTypeService.deleteArticleType(requestBodyData.getPostData().getId())?ModifyState.SUCCESS:ModifyState.FAILD;
    }
    @PutMapping("update-article-type")
    @CheckToken
    public Integer updateArticleType(@RequestBody RequestBodyData<ArticleType> requestBodyData){
        articleTypeService.updateArticleType(requestBodyData.getPostData());
        return ModifyState.SUCCESS;
    }
}
