package org.example.warehousemanagersystem.study.建造者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description:
 * @Version: 1.0
 */


public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
