package org.example.warehousemanagersystem.study.命令模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description: 将请求封装为一个对象，允许用户使用不同的请求对客户端进行参数化。
 * @Version: 1.0
 */


public class SellStock implements Order{
    //创建实体类
    private Stock abcStock;
    //添加实体类
    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }
    //执行实体类
    @Override
    public void execute() {
        abcStock.sell();
    }
}
