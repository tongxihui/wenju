package com.kddyzn.wenju.model.typehandler;

import com.kddyzn.wenju.annotation.EnumTypeHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class BaseEnumHandler<E extends Enum<E>> extends BaseTypeHandler<E> {

    private Class<E> clazz;

    public BaseEnumHandler() {
        if (!this.getClass().isAnnotationPresent(EnumTypeHandler.class)) {
            String msg = "[BaseEnumTypeHandler]" + this.getClass() + " must add BaseEnumTypeHandler annotation";
            log.error(msg);
            throw new RuntimeException(msg);
        }
        EnumTypeHandler annotation = this.getClass().getAnnotation(EnumTypeHandler.class);
        this.clazz = annotation.target();
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            preparedStatement.setString(i, e.name());
        } else {
            preparedStatement.setObject(i, e.name(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String result = resultSet.getString(s);
        return result == null ? null : Enum.valueOf(this.clazz, result);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String result = resultSet.getString(i);
        return result == null ? null : Enum.valueOf(this.clazz, result);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String result = callableStatement.getString(i);
        return result == null ? null : Enum.valueOf(this.clazz, result);
    }
}
