package com.offcn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * name:uedu-am
 * author: xiaoming
 **/
@Configuration //配置类
public class FileConfig implements WebMvcConfigurer {

    /**
     * addResourceHandler:指定客户端访问的地址路径
     * addResourceLocations:通过上面的路径可以匹配到服务器上对应路径下的资源
     *
     * 客户端,发送请求: http://localhost:8080/upload/xxx.jpg  ====>D:/2022郑州实习/upload/xxx.jpg
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:\\2022郑州实习\\upload\\");
    }
}
