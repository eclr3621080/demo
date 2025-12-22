package org.example.warehousemanagersystem.study.建造者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description: 创建实现 Packing 接口的实体类。
 * @Version: 1.0
 */
public class Bottle implements Packing{
    @Override
    public String pack() {
        return "Bottle";
    }
}
