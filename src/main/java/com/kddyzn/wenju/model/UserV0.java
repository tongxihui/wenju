package com.kddyzn.wenju.model;

import com.kddyzn.wenju.model.enums.UserStatusEnum;
import com.kddyzn.wenju.dao.po.auto.UserP0;
import lombok.Data;

@Data
public class UserV0 {
    private String userId;

    private String phone;

    private String nickName;

    private String realName;

    private String email;

    private String qq;

    private String wx;

    private UserStatusEnum status;

    private String extra;

    public static UserV0 toUserVo(UserP0 userP0) {
        UserV0 userV0 = new UserV0();
        userV0.userId = userP0.getUserId();
        userV0.phone = userP0.getPhone();
        userV0.nickName = userP0.getNickName();
        userV0.realName = userP0.getRealName();
        userV0.email = userP0.getEmail();
        userV0.qq = userP0.getQq();
        userV0.wx = userP0.getWx();
        userV0.status = userP0.getStatus();
        userV0.extra = userP0.getExtra();
        return userV0;
    }
}
