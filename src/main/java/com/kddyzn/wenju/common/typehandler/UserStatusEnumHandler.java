package com.kddyzn.wenju.common.typehandler;

import com.kddyzn.wenju.annotation.EnumTypeHandler;
import com.kddyzn.wenju.common.enums.UserStatusEnum;

import java.sql.Types;

@EnumTypeHandler(target = UserStatusEnum.class, jdbcType = Types.VARCHAR)
public class UserStatusEnumHandler extends BaseEnumHandler {}
