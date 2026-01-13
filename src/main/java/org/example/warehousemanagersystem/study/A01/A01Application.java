package org.example.warehousemanagersystem.study.A01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;


/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */

@SpringBootApplication
public class A01Application {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(A01Application.class, args);
        Resource[] resource = context.getResources("C:\\Users\\User\\IdeaProjects\\demo\\src\\main\\java\\org\\example\\warehousemanagersystem\\study\\A01");
        for (Resource r : resource) {
            System.out.println(r.getFilename());
        }
        System.out.println("aaaaa"+context.getEnvironment().getProperty("java_home"));
        System.out.println("xxxx"+context.getEnvironment().getProperty("server.port"));
        context.getBean(Component1.class).register();


    }
}
