package org.example.warehousemanagersystem.study.组合实体模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class CompositeEntityPatternDemo {
    public static void main(String[] args) {
        Client client=new Client();
        client.setData("Test","Data");
        client.printData();
        client.setData("Test2","Data2");
        client.printData();
    }
}
