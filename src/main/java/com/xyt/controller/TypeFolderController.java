package com.xyt.controller;

import com.xyt.annotation.CheckModified;
import com.xyt.authorization.ModifyState;
import com.xyt.authorization.RequestBodyData;
import com.xyt.entity.TypeFolder;
import com.xyt.service.TypeFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class TypeFolderController {
    @Autowired
    private TypeFolderService typeFolderService;
    @GetMapping("/get-type-folder-list")
    public List<TypeFolder> getTypeFolderList(Integer parentId){
        return typeFolderService.getTypeFolderByType(parentId);
    }
    @PostMapping("/add-type-folder")
    @CheckModified
    public Integer addTypeFolder(@RequestBody RequestBodyData<TypeFolder> requestBodyData){
        TypeFolder typeFolder = requestBodyData.getPostData();
        typeFolderService.addTypeFolder(typeFolder);
        return typeFolder.getId();
    }
    @PutMapping("/update-type-folder")
    @CheckModified
    public Integer updateTypeFolder(@RequestBody RequestBodyData<TypeFolder> requestBodyData){
        return typeFolderService.updateTypeFolder(requestBodyData.getPostData())?ModifyState.SUCCESS:ModifyState.FAILD;
    }
    @DeleteMapping("/delete-type-folder")
    @CheckModified
    public Integer deleteTypeFolder(@RequestBody RequestBodyData<TypeFolder> requestBodyData){
       return typeFolderService.deleetTypeFolder(requestBodyData.getPostData().getId())?ModifyState.SUCCESS:ModifyState.FAILD;

    }
}
