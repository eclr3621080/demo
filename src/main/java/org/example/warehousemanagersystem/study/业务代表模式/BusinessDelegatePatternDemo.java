package org.example.warehousemanagersystem.study.业务代表模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:     抽象和封装应用程序的访问逻辑，从而为表示层提供对业务逻辑层的访问。
 * @Version: 1.0
 */


public class BusinessDelegatePatternDemo {
    public static void main(String[] args) {
        BusinessDelegate businessDelegate=new BusinessDelegate();
        //环境创建成EJB
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();
        System.out.println("-----------------------");

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }
}
