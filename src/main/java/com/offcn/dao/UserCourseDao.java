package com.offcn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserCourseDao {

    /**
     * 查询选课及其选课人的分页信息
     * @param pramas
     * @return
     */
    @Select({
            "<script>" +
                    "select courseName,name " +
                    "from course_user cu," +
                    "course c,user u " +
                    "where cu.cid=c.cid and cu.uid=u.uid " +
                    "<if test='username != null'>" +
                    "and name=#{username}" +
                    "</if>" +
                    "limit #{pageOff},#{pageSize}</script>"
    })
    List<Map<String,String>> findUserAndCourseByPage(Map<String,Object> pramas);
}
