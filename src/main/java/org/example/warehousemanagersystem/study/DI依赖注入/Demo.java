package org.example.warehousemanagersystem.study.DI依赖注入;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-19
 * @Description:
 * @Version: 1.0
 */


public class Demo {
    public static void main(String[] args) {
        // 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("application.properties");
        // 方式1：通过名称获取Bean
        Student student1 = (Student) context.getBean("student");
        System.out.println("通过名称获取: " + student1);


    }
}
