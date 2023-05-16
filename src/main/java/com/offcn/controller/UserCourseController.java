package com.offcn.controller;

import com.offcn.dao.UserCourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * name:uedu-am
 * author: xiaoming
 **/
@RestController
public class UserCourseController {
    @Autowired
    private UserCourseDao userCourseDao;

    /**
     * 选课及其选课人信息分页显示
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @RequestMapping("/findUserCourseByPage")
    public Object findUserCourseByPage(Integer currentPage,
                                       Integer pageSize,
                                       String search){
        Map<String,Object> map=new HashMap<>();
        map.put("username",search);
        map.put("pageOff",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Map<String, String>> list = userCourseDao.findUserAndCourseByPage(map);
        return CollectionUtils.isEmpty(list)?"fail":list;
    }
}
