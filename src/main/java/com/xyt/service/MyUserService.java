package com.xyt.service;

import com.xyt.entity.MyUser;
import com.xyt.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {
    @Autowired
    private MyUserMapper myUserMapper;
    public MyUser getMyUser(String email){
        return myUserMapper.getMyUserByEmail(email);
    }
}
