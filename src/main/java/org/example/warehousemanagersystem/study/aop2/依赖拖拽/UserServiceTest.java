package org.example.warehousemanagersystem.study.aop2.依赖拖拽;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-19
 * @Description:
 * @Version: 1.0
 */


import org.example.warehousemanagersystem.study.aop2.依赖注入.Impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖拖拽:注入的对象如何与组件发生联系，这个过程就是通过依赖拖拽实现 。(较少有使用)
 * 而通常对注入对象的配置可以通过一个 xml 文件完成。依赖拖拽就是通过这种方式对对象进行集中管理。
 */
public class UserServiceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
        UserServiceImpl userService = (UserServiceImpl) classPathXmlApplicationContext.getBean("UserServiceImpl");
        userService.test();
    }
}
