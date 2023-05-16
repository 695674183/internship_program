package com.offcn.controller;

import com.offcn.dao.CourseDao;
import com.offcn.dao.CourseDetailDao;
import com.offcn.pojo.Course;
import com.offcn.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * name:uedu-am
 * author: xiaoming
 **/
@RestController
public class CourseController {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseDetailDao courseDetailDao;
    /**
     * 课程的分页显示
     * @param currentPage:页码
     * @param pageSize:每一页显示的条数
     * @param search:搜索条件
     * @return
     */
    @RequestMapping("/findAllByPage")
    public Object findAllByPage(Integer currentPage,Integer pageSize,String search){
        Map<String,Object> map=new HashMap<>();
        map.put("courseName",search);
        map.put("pageoff",(currentPage-1)*pageSize);
        map.put("pagesize",pageSize);
        //当前页显示的多条数据
        List<Course> list = courseDao.findByPage(map);
        if(CollectionUtils.isEmpty(list)){
            return "fail";
        }
        //封装的分页对象
        Page<Course> page = new Page<>(list, currentPage, pageSize);
        return page;
    }

    /**
     * 上传文件(图片,视频)
     * @param file
     * @return
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        //获取上传的文件名
        String filename = file.getOriginalFilename();
        //重新设置文件名
        filename= UUID.randomUUID().toString()+filename;
        //设置文件存放位置
        String path="D:\\2022郑州实习\\files\\"+filename;
        //文件对象
        File f=new File(path);
        //保存文件
        file.transferTo(f);
        return filename;
    }

    /**
     * 添加课程
     * @param course
     * @return
     */
    @RequestMapping("/addCourse")
    public String addCourse(@RequestBody Course course){
        //设置课程对象中的上传时间
        course.setCreateTime(new Date());
        //调用添加课程的方法
        int i = courseDao.addCourse(course);
        return i>0?"success":"fail";
    }

    /**
     * 删除课程
     * @param cids
     * @return
     */
    @RequestMapping("/delCourseByCid")
    public String delCourseByCid(Integer[]cids){
        try {
            //遍历需要删除的课程编号的数组
            for (Integer cid : cids) {
                //先删除课程对应的课程章节
                courseDetailDao.deleteByCid(cid);
                //再删除课程
                courseDao.deleteById(cid);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    /**
     * 更新课程
     * @param course
     * @return
     */
    @RequestMapping("/updateCourse")
    public String updateCourse(@RequestBody Course course){
        course.setCreateTime(new Date());
        int i = courseDao.updateById(course);
        return i>0?"success":"fail";
    }
}
