package org.example.warehousemanagersystem.common.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description: Sa-Token权限拦截配置
 * @Version: 1.0
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    // 注册 Sa-Token 拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器
        registry.addInterceptor(new SaInterceptor(handler -> {
                    // 指定拦截的路由
                    SaRouter
                            // 拦截所有路径
                            .match("/**")
                            // 排除登录、注册等公开路径 + Swagger所有资源路径
                            .notMatch(
                                    "/user/loginuser",
                                    "/user/infouser",
                                    "/auth/register",
                                    "/error",
                                    // Swagger UI 页面及静态资源
                                    "/swagger-ui.html",
                                    "/swagger-ui/**",
                                    "/swagger-ui/index.html",
                                    // OpenAPI 文档接口
                                    "/v3/api-docs",
                                    "/v3/api-docs/**"
                            )
                            // 对匹配路径进行登录校验
                            .check(r -> StpUtil.checkLogin());
                })).addPathPatterns("/**")
                .excludePathPatterns("/error");
    }
}
