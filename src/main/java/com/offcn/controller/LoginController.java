package com.offcn.controller;

import com.offcn.dao.UserDao;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * name:uedu-am
 * author: xiaoming
 **/
@RestController
public class LoginController {

    @Autowired
    private UserDao userDao;

    /**
     * 登录
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestBody Map<String, String> map){
        //获取输入框中的验证码
        String imageCode = map.get("imageCode");
        //从session对象中获取生成的验证码
        String code = (String) session.getAttribute("code");
        //在比对验证码并且忽略大小写的情况,如果不一致,直接响应登录失败
        if(!imageCode.equalsIgnoreCase(code)){
            return "fail";
        }
        //获取输入框的用户名与密码
        String username = map.get("username");
        String password = map.get("password");

        User user = userDao.selectByUsernameAndPassword(username, password);
        //如果为空,那么代表没有查询到数据
        if(user==null){
            return "fail";
        }
        //将登录成功的用户添加到该对象中
        session.setAttribute("user",user);
        return "success";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //销毁session对象
        session.invalidate();
        return "success";
    }
}
