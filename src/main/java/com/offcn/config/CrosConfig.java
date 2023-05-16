package com.offcn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * name:offcnpe_parent
 * author: xiaoming
 **/
@Configuration
public class CrosConfig implements WebMvcConfigurer {

    /**
     * 用来处理跨域问题
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //
        registry.addMapping("/**")//处理所有的请求url地址   /checkitem/page     checkitem/save
                .allowedOriginPatterns("*")//处理所有的ip
                .allowedHeaders("*")//处理任意的请求头信息
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")//允许的请求方法
                .maxAge(3600)//设置有效期
                .allowCredentials(true);//启动跨域配置
    }
}
