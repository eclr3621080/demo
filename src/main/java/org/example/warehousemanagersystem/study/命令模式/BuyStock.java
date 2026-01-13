package org.example.warehousemanagersystem.study.命令模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description: 创建实现了 Order 接口的实体类。
 * @Version: 1.0
 */


public class BuyStock implements Order {
    //实体类
    private Stock abcStock ;
    //创建实体类
    public BuyStock(Stock stock) {
        this.abcStock  = stock;
    }
    //执行实体类
    @Override
    public void execute() {
        abcStock.buy();
    }
}
