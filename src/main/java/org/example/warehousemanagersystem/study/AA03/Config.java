package org.example.warehousemanagersystem.study.AA03;

import org.example.warehousemanagersystem.study.A02.Bean1;
import org.example.warehousemanagersystem.study.A02.Bean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */

@Configuration
public class Config
{
    @Bean
    public Bean1 bean1(){
        return new Bean1();
    }
    @Bean
    public Bean2 bean2(Bean1 bean1){
        Bean2 bean2 = new Bean2();
        bean2.setBean1(bean1);
        return bean2;
    }
}
