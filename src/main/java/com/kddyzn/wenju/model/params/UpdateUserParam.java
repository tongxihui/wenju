package com.kddyzn.wenju.model.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserParam {

    @NotNull(message = "用户名不能为空")
    private String userId;

    private String phone;

    private String nickName;

    private String email;

    private String qq;

    private String wx;
}
