package com.offcn.dao;

import com.offcn.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseDao {

    /**
     * sql: select * from course where courseName like '%java%' limit 0,3
     * 在这里,搜索条件可能为空,所以这里采用动态sql语句
     * @param pramas
     * @return
     */
    @Select({"<script>" +
            "select * from course " +
            "<where>" +
            "<if test='courseName != null'>" +
            "courseName like '%${courseName}%'" +
            "</if>" +
            "</where>" +
            "limit #{pageoff},#{pagesize}" +
            "</script>"})
    List<Course>findByPage(Map<String,Object> pramas);

    /**
     * 添加课程
     * @param course
     * @return
     */
    @Insert("insert course values(#{cid},#{courseName},#{descs},#{courseType}," +
            "#{courseImage},#{courseVideo},#{coursePrice},#{status},#{createTime})")
    int addCourse(Course course);

    /**
     * 删除课程
     * @param cid
     * @return
     */
    @Delete("delete from course where cid=#{cid}")
    int deleteById(Integer cid);

    @Update("update course set courseName=#{courseName},descs=#{descs}," +
            "courseType=#{courseType},courseImage=#{courseImage}," +
            "courseVideo=#{courseVideo},coursePrice=#{coursePrice}," +
            "status=#{status},createTime=#{createTime}" +
            "where cid=#{cid}"
            )
    int updateById(Course course);
}
