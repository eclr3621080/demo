package org.example.warehousemanagersystem.springboot的启动流程;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-02
 * @Description:
 * @Version: 1.0
 */

@SpringBootApplication
public class SpringbootDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDemoApplication.class, args);
        Object demoService = run.getBean("demoService");
        System.out.println("demoService = " + demoService);

    }
    public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
        return new SpringApplication(primarySources).run(args);
    }


}
