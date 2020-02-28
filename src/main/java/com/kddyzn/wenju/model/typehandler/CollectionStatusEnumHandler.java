package com.kddyzn.wenju.model.typehandler;

import com.kddyzn.wenju.annotation.EnumTypeHandler;
import com.kddyzn.wenju.model.enums.CollectionStatusEnum;

import java.sql.Types;

@EnumTypeHandler(target = CollectionStatusEnum.class, jdbcType = Types.VARCHAR)
public class CollectionStatusEnumHandler extends BaseEnumHandler {
}
