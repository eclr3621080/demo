package org.example.warehousemanagersystem.study.AA03;

import org.example.warehousemanagersystem.study.A02.Bean2;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */


public class AppliactionContext的常见实现和用法 {
    private static void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("a02.xml");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        System.out.println(context.getBean(Bean2.class).getBean1());
    }

    private static void testFileSystemApplicationContext() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("a02.xml");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        System.out.println("读取之前...里面空空如也");
        for (String beanName : defaultListableBeanFactory.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        System.out.println("读取之后");
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(new FileSystemResource("C:\\Users\\User\\IdeaProjects\\demo\\src\\main\\java\\org\\example\\warehousemanagersystem\\study\\AA03\\a02.xml"));
        for (String name : defaultListableBeanFactory.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}
