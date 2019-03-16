package com.xyt.mapper;

import com.xyt.entity.MyUser;

public interface MyUserMapper {
   MyUser getMyUserByEmail(String email);
   void insertMyUser(MyUser myUser);
   void updateMyUser(MyUser myUser);
}
