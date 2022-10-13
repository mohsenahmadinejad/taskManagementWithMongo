package com.ampada.taskmanagementwithmongo.security.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ActiveUser {
    public String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
