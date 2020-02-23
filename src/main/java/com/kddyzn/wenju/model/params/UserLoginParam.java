package com.kddyzn.wenju.model.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginParam {

    @NotNull(message = "账号不能为空")
    private String userId;

    @NotNull(message = "密码不能为空")
    private String password;
}
