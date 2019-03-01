package com.xyt.model;

import java.util.Date;

public class Comment {
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer targetType;
    private Integer target;
    private String content;///最长为256字节
    private Date createdDate;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTartgetType() {
        return targetType;
    }

    public void setTartgetType(Integer tartgetType) {
        this.targetType = tartgetType;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
