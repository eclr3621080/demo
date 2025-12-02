package org.example.warehousemanagersystem.study.aop2.Setter方法注入;

import org.example.warehousemanagersystem.study.aop2.依赖注入.UserMapperAopTest;
import org.example.warehousemanagersystem.study.aop2.依赖注入.UserServiceAopTest;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-19
 * @Description:
 * @Version: 1.0
 */


public class UserServiceSetterImpl implements UserServiceAopTest {
    private UserMapperAopTest  userMapperAopTest;
    //写入set，就是setter方法注入
    public void setUserMapperAopTest(UserMapperAopTest userMapperAopTest) {
        this.userMapperAopTest = userMapperAopTest;
    }

    @Override
    public void test() {
        userMapperAopTest.test();
    }
}
