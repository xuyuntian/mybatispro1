package com.xyt.controller;

import com.xyt.authorization.ContentOfToken;
import com.xyt.authorization.ModifyState;
import com.xyt.authorization.MyJwt;
import com.xyt.authorization.RequestBodyData;
import com.xyt.entity.MyUser;
import com.xyt.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
public class UserAccountController {
    @Autowired
    private MyUserService myUserService;
    @Autowired
    private MyJwt myJwt;
    @GetMapping("/get-token")
    public ContentOfToken geToken(@RequestBody RequestBodyData<String> requestBodyData){
        MyUser user = requestBodyData.getMyUser();
        MyUser myUser = myUserService.getMyUser(user.getEmail());
        ContentOfToken contentOfToken = new ContentOfToken();
        if(myUser==null){
            contentOfToken.setState(ModifyState.NO_SUCH_EMAIL);
        }else if(user.getEmail()==null || !user.getEmail().equals(myUser.getEmail())){
            contentOfToken.setState(ModifyState.WRONG_PASSWORD);
        }else{
            contentOfToken.setState(ModifyState.SUCCESS);
            contentOfToken.setType(myUser.getType());
            String token = null;
            try {
                token =myJwt.createToken(user.getEmail(),myUser.getType());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            contentOfToken.setToken(token);
        }
        return contentOfToken;
    }
}
