package org.example.warehousemanagersystem.study.aop2.依赖注入.Impl;

import org.example.warehousemanagersystem.study.aop2.依赖注入.UserMapperAopTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-19
 * @Description:
 * @Version: 1.0
 */


public class DemoTest {


    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserMapperAopTest userMapperAopTest=new UserMapperAopTest(){

            @Override
            public void createUserMapper(UserMapperAopTest userMapperAopTest) {
                userMapperAopTest.test();
            }

            @Override
            public void test() {
                System.out.println("UserMapper test方法被调用");
            }
        };

        userService.createUserMapper(userMapperAopTest);
        userMapperAopTest.test();

    }
}
