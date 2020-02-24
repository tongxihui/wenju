package com.kddyzn.wenju.dao.mapper.auto;

import com.kddyzn.wenju.dao.po.auto.CommitP0;
import com.kddyzn.wenju.dao.po.auto.CommitP0Example;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommitMapper {
    long countByExample(CommitP0Example example);

    int deleteByExample(CommitP0Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommitP0 record);

    int insertSelective(CommitP0 record);

    List<CommitP0> selectByExample(CommitP0Example example);

    CommitP0 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommitP0 record, @Param("example") CommitP0Example example);

    int updateByExample(@Param("record") CommitP0 record, @Param("example") CommitP0Example example);

    int updateByPrimaryKeySelective(CommitP0 record);

    int updateByPrimaryKey(CommitP0 record);
}