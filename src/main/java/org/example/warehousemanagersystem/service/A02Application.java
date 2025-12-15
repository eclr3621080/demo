package org.example.warehousemanagersystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A02Application {
    private static final Logger log = LoggerFactory.getLogger(A02Application.class);
    public static void main(String[] args) {
        //testClassPathXmlApplicationContext
        //testFileSystemXmlApplicationContext

    }
    //从xml格式的配置文件来创建
    private static void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("b01.xml");

    }
    private static void testFileSystemXmlApplicationContext() {

    }
}
