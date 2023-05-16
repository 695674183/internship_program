package com.offcn.controller;

import com.offcn.util.ValidateCodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * name:uedu-am
 * author: xiaoming
 **/
@RestController
public class ValidateController {

    /**
     * 生成验证码图片
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getCode")
    public void getCode(HttpSession session,HttpServletResponse response)throws Exception{
        //获取验证码
        String code = ValidateCodeUtil.getSecurityCode();
        //将生成的验证码保存到session会话中
        session.setAttribute("code",code);
        //生成验证码图片
        BufferedImage image = ValidateCodeUtil.createImage(code);
        //将图片响应回客户端
        //参数1:图片对象;参数2:响应回去的图片的格式;参数3:响应流对象
        ImageIO.write(image,"jpeg",response.getOutputStream());
    }
}
