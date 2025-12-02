package org.example.warehousemanagersystem.study.aop2.构造器注入;

import org.example.warehousemanagersystem.service.user.service.UserService;
import org.example.warehousemanagersystem.study.aop2.依赖注入.UserMapperAopTest;
import org.example.warehousemanagersystem.study.aop2.依赖注入.UserServiceAopTest;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-19
 * @Description:
 * @Version: 1.0
 */


public class UserServiceImpl implements UserServiceAopTest {
    private UserMapperAopTest userMapperAopTest;




    /**
     * 构造方法注入
     * @param userMapperAopTest
     */
    public UserServiceImpl(UserMapperAopTest userMapperAopTest) {
        this.userMapperAopTest = userMapperAopTest;
    }
    @Override
    public void test() {
        userMapperAopTest.test();
    }
}
