package org.example.warehousemanagersystem.study.aop2.上下文依赖查找;

import org.example.warehousemanagersystem.study.aop2.依赖注入.UserMapperAopTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-19
 * @Description:在某些方面跟依赖拖拽类似，但是上下文依赖查找中，查找的过程是在容器管理的资源中进行的，而不是从集中注册表中，并且通常是作用在某些设置点上。
 * @Version: 1.0
 */


public class UserServiceImpl {
    private DataSource dataSource;
    private UserMapperAopTest userMapperAopTest;


    public UserServiceImpl() {
        Context context=null;
        try {
            context=new InitialContext();
            dataSource = (DataSource) context.lookup("java:com/jourwon/dataSourceName");
            userMapperAopTest = (UserMapperAopTest) context.lookup("java:com/jourwon/UserMapperName");
        } catch (Exception e) {

        }
    }
}
