package org.example.warehousemanagersystem.study.建造者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description: 创建扩展了Burger 和ColdDrink的实体类
 * 这个属于事Burger抽象类的子类，子类重写父类
 * @Version: 1.0
 */


public class VegBurger extends Burger{

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
