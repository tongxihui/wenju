package com.kddyzn.wenju.dao.mapper.redis;

import com.kddyzn.wenju.model.UserSecret;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserSecretMapper {
    @Insert("insert into wenju_user_secret(user_id,utoken) values(#{userId},#{utoken}")
    int addUserSecret(@Param("userId") String userId, @Param("utoken") String utoken);

    @Select("select * from wenju_user_secret where user_id =#{userId}")
    UserSecret findById(@Param("userId") String userId);

    @Update("update wenju_user_secret set user_id=#{userId},utoken=#{utoken}) where userId={#userId}")
    int updateById(UserSecret userSecret);

    @Delete("delete from wenju_user_secret where user_id=#{userId}")
    void deleteById(@Param("userId") String userId);
}
