package com.kddyzn.wenju.model.typehandler;

import com.kddyzn.wenju.annotation.EnumTypeHandler;
import com.kddyzn.wenju.model.enums.UserStatusEnum;

import java.sql.Types;

@EnumTypeHandler(target = UserStatusEnum.class, jdbcType = Types.VARCHAR)
public class UserStatusEnumHandler extends BaseEnumHandler {}
