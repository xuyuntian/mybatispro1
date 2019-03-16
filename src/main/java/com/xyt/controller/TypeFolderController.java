package com.xyt.controller;

import com.xyt.authorization.ModifyState;
import com.xyt.authorization.RequestBodyData;
import com.xyt.entity.TypeFolder;
import com.xyt.service.TypeFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeFolderController {
    @Autowired
    private TypeFolderService typeFolderService;
    @GetMapping("/get-type-folder-list")
    public List<TypeFolder> getTypeFolderList(Integer parentId){
        return typeFolderService.getTypeFolderByType(parentId);
    }
    @PostMapping("/add-type-folder")
    public Integer addTypeFolder(@RequestBody RequestBodyData<TypeFolder> requestBodyData){
        return typeFolderService.addTypeFolder(requestBodyData.getPostData())? ModifyState.SUCCESS:ModifyState.FAILD;
    }
    @PutMapping("/update-type-folder")
    public Integer updateTypeFolder(@RequestBody RequestBodyData<TypeFolder> requestBodyData){
        return typeFolderService.updateTypeFolder(requestBodyData.getPostData())?ModifyState.SUCCESS:ModifyState.FAILD;
    }
    @DeleteMapping("/delete-type-folder")
    public Integer deleteTypeFolder(@RequestBody RequestBodyData<TypeFolder> requestBodyData){
       return typeFolderService.deleetTypeFolder(requestBodyData.getPostData().getId())?ModifyState.SUCCESS:ModifyState.FAILD;

    }
}
