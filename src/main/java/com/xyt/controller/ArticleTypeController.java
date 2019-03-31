package com.xyt.controller;

import com.xyt.annotation.CheckDelete;
import com.xyt.annotation.CheckModified;
import com.xyt.authorization.ModifyState;
import com.xyt.authorization.RequestBodyData;
import com.xyt.entity.ArticleType;
import com.xyt.entity.MyUser;
import com.xyt.entity.TypeFolder;
import com.xyt.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;
    @GetMapping("get-article-type-list")
    public List<ArticleType> getArticleTypeList(){
        return articleTypeService.getArticleType();
    }
    @PostMapping("add-article-type")
    @CheckModified
    public Integer addArticleType(@RequestBody RequestBodyData<ArticleType> requestBodyData){
        ArticleType articleType =requestBodyData.getPostData();
        articleTypeService.addArticleType(articleType);
        return articleType.getId();
    }
    @DeleteMapping("delete-article-type")
    @CheckDelete
    public Integer deleteArticleType(@RequestParam String email,@RequestParam String type, @RequestParam Integer id,
                                     @RequestParam String token){
        return articleTypeService.deleteArticleType(id)?ModifyState.SUCCESS:ModifyState.FAILD;
    }
    @PutMapping("update-article-type")
    @CheckModified
    public Integer updateArticleType(@RequestBody RequestBodyData<ArticleType> requestBodyData){
        articleTypeService.updateArticleType(requestBodyData.getPostData());
        return ModifyState.SUCCESS;
    }
}
