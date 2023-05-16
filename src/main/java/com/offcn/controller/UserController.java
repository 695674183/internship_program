package com.offcn.controller;

import com.offcn.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * name:uedu-am
 * author: xiaoming
 **/
@RestController
public class UserController {

    /**
     * 获取登录的用户信息
     * @param session
     * @return
     */
    @RequestMapping("/getUserInfo")
    public Object getUserInfo(HttpSession session){
        //从session中获取用户
        Object user = session.getAttribute("user");
        //如果没有登录
        if(user==null){
            return "fail";
        }else{
            User u= (User) user;
            return u;
        }
    }
}
