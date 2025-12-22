package org.example.warehousemanagersystem.study.建造者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description:
 * @Version: 1.0
 */


public abstract  class ColdDrink implements Item{
    @Override
    public abstract float price();

    @Override
    public  Packing packing(){
        return new Bottle();
    }
}
