package com.offcn.dao;

import com.offcn.pojo.CourseDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDetailDao {

    /**
     * 添加课程章节
     * @param courseDetail
     * @return
     */
    @Insert("insert into coursedetail values(" +
            "#{id},#{name},#{type},#{url},#{startData},#{cid})")
    int add(CourseDetail courseDetail);

    /**
     * 根据课程的编号删除课程章节信息
     * @param cid
     * @return
     */
    @Delete("delete from coursedetail where cid=#{cid}")
    int deleteByCid(Integer cid);
}
