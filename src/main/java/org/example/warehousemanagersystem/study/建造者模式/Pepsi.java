package org.example.warehousemanagersystem.study.建造者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description: 重写ColdDrink
 * @Version: 1.0
 */


public class Pepsi extends ColdDrink{

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
