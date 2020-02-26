package com.kddyzn.wenju.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSecret implements Serializable {

    private String userId;

    private String utoken;

    public UserSecret(String userId, String utoken) {
        super();
        this.userId = userId;
        this.utoken = utoken;
    }
}
