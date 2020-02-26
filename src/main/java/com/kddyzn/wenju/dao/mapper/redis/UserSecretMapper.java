package com.kddyzn.wenju.dao.mapper.redis;

import com.kddyzn.wenju.model.UserSecret;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserSecretMapper {
    @Insert("insert into user_secret(userId,utoken) values(#{userId},#{utoken})")
    int addUserSecret(@Param("userId") String userId, @Param("utoken") String utoken);

    @Select("select * from user_secret where userId =#{userId})")
    UserSecret findById(@Param("userId") String userId);

    @Update("update user_secret set userId=#{userId},utoken=#{utoken}) where userId={#userId})")
    int updateById(UserSecret userSecret);

    @Delete("delete from user_secret where userId=#{userId})")
    void deleteById(@Param("userId") String userId);
}
