package com.xyt.authorization;

import com.xyt.entity.MyUser;

public class RequestBodyData<T> {
    private T postData;
    private MyUser myUser;
    private String token;

    public T getPostData() {
        return postData;
    }

    public void setPostData(T postData) {
        this.postData = postData;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }
}
