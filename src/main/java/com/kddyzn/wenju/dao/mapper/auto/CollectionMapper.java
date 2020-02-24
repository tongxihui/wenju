package com.kddyzn.wenju.dao.mapper.auto;

import com.kddyzn.wenju.dao.po.auto.CollectionP0;
import com.kddyzn.wenju.dao.po.auto.CollectionP0Example;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollectionMapper {
    long countByExample(CollectionP0Example example);

    int deleteByExample(CollectionP0Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(CollectionP0 record);

    int insertSelective(CollectionP0 record);

    List<CollectionP0> selectByExampleWithBLOBs(CollectionP0Example example);

    List<CollectionP0> selectByExample(CollectionP0Example example);

    CollectionP0 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CollectionP0 record, @Param("example") CollectionP0Example example);

    int updateByExampleWithBLOBs(@Param("record") CollectionP0 record, @Param("example") CollectionP0Example example);

    int updateByExample(@Param("record") CollectionP0 record, @Param("example") CollectionP0Example example);

    int updateByPrimaryKeySelective(CollectionP0 record);

    int updateByPrimaryKeyWithBLOBs(CollectionP0 record);

    int updateByPrimaryKey(CollectionP0 record);
}