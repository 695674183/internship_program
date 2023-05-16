package com.offcn.dao;

import com.offcn.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    //根据用户名与密码到数据库进行查询,是否存在对应的信息
    @Select("select * from user where username=#{u} and password=#{p}")
    User selectByUsernameAndPassword(@Param("u") String username, @Param("p") String password);
}
