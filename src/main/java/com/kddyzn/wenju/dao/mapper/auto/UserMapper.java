package com.kddyzn.wenju.dao.mapper.auto;

import com.kddyzn.wenju.dao.po.auto.UserP0;
import com.kddyzn.wenju.dao.po.auto.UserP0Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserP0Example example);

    int deleteByExample(UserP0Example example);

    int deleteByPrimaryKey(String userId);

    int insert(UserP0 record);

    int insertSelective(UserP0 record);

    List<UserP0> selectByExample(UserP0Example example);

    UserP0 selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserP0 record, @Param("example") UserP0Example example);

    int updateByExample(@Param("record") UserP0 record, @Param("example") UserP0Example example);

    int updateByPrimaryKeySelective(UserP0 record);

    int updateByPrimaryKey(UserP0 record);
}