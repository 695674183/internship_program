package com.offcn.controller;

import com.offcn.dao.CourseDetailDao;
import com.offcn.pojo.CourseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * name:uedu-am
 * author: xiaoming
 **/
@RestController
public class CourseDetailController {
    @Autowired
    private CourseDetailDao courseDetailDao;

    /**
     * 添加课程章节
     * @param courseDetail
     * @return
     */
    @RequestMapping("/addCourseDetail")
    public String addCourseDetail(@RequestBody CourseDetail courseDetail){
        int i = courseDetailDao.add(courseDetail);
        return i>0?"success":"fail";
    }
}
