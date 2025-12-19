package org.example.warehousemanagersystem.resttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-15
 * @Description:
 * @Version: 1.0
 */

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
