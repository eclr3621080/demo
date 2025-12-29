package org.example.warehousemanagersystem.study.a04;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-17
 * @Description:
 * @Version: 1.0
 */

/**
 * java.home=
 * java.version=
 */
@ConfigurationProperties(prefix = "java")
@Component
public class Bean4 {
    private String home;
    private String version;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
