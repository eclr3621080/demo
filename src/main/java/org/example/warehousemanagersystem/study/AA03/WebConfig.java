package org.example.warehousemanagersystem.study.AA03;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */

@Configuration
public class WebConfig {
    @Bean //产生内嵌的Tomcat服务器
    public ServletWebServerFactory servletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }
    @Bean //核心，DispatcherServlet，请求入口点，【前控制器】
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
    @Bean //把 DispatcherServlet 注册到 Tomcat服务器 中
    public DispatcherServletRegistrationBean registrationBean(DispatcherServlet dispatcherServlet) {
        return new DispatcherServletRegistrationBean(dispatcherServlet, "/");
    }
    @Bean("/hello") //控制器，实现Controller接口
    public Controller controller1() {
        return (request, response) -> {
            response.getWriter().print("hello");
            return null;
        };
    }

}
