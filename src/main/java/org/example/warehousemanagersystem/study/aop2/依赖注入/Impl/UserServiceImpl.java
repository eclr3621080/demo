package org.example.warehousemanagersystem.study.aop2.依赖注入.Impl;

import org.example.warehousemanagersystem.study.aop2.依赖注入.UserMapperAopTest;
import org.example.warehousemanagersystem.study.aop2.依赖注入.UserServiceAopTest;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-19
 * @Description: Description:service实现类
 * @Version: 1.0
 */


public class UserServiceImpl implements UserServiceAopTest, UserMapperAopTest {
    private UserMapperAopTest userMapperAopTest;

    @Override
    public void createUserMapper(UserMapperAopTest userMapperAopTest) {

        this.userMapperAopTest = userMapperAopTest;
    }

    @Override
    public void test() {
        System.out.println("test");
    }


}
