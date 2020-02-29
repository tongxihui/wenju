package com.kddyzn.wenju.dao.mapper.auto;

import com.kddyzn.wenju.dao.po.auto.UserSecretP0;
import com.kddyzn.wenju.dao.po.auto.UserSecretP0Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecretMapper {
    long countByExample(UserSecretP0Example example);

    int deleteByExample(UserSecretP0Example example);

    int deleteByPrimaryKey(String userId);

    int insert(UserSecretP0 record);

    int insertSelective(UserSecretP0 record);

    List<UserSecretP0> selectByExample(UserSecretP0Example example);

    UserSecretP0 selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserSecretP0 record, @Param("example") UserSecretP0Example example);

    int updateByExample(@Param("record") UserSecretP0 record, @Param("example") UserSecretP0Example example);

    int updateByPrimaryKeySelective(UserSecretP0 record);

    int updateByPrimaryKey(UserSecretP0 record);
}