package org.example.warehousemanagersystem.study.建造者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description: 创建实现Item接口的抽象类，该类提供了默认的功能
 * @Version: 1.0
 */


public abstract class Burger implements Item {
    //返回一个  "Wrapper"
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
