package com.kddyzn.wenju.dao.mapper.auto;

import com.kddyzn.wenju.dao.po.auto.FileP0;
import com.kddyzn.wenju.dao.po.auto.FileP0Example;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileMapper {
    long countByExample(FileP0Example example);

    int deleteByExample(FileP0Example example);

    int deleteByPrimaryKey(Long id);

    int insert(FileP0 record);

    int insertSelective(FileP0 record);

    List<FileP0> selectByExample(FileP0Example example);

    FileP0 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileP0 record, @Param("example") FileP0Example example);

    int updateByExample(@Param("record") FileP0 record, @Param("example") FileP0Example example);

    int updateByPrimaryKeySelective(FileP0 record);

    int updateByPrimaryKey(FileP0 record);
}