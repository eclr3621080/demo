package org.example.warehousemanagersystem.study.a03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-17
 * @Description:
 * @Version: 1.0
 */

@SpringBootApplication
public class A03Applictaion {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A03Applictaion.class, args);
        context.close();
    }
}
